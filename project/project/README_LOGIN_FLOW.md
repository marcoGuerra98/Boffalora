# Flusso Login - Boffalora (stato attuale)

## 1) Accesso alla pagina login
1. Browser chiama `GET /`.
2. `LogInController` reindirizza a `GET /login`.
3. Spring Security permette `/` e `/login` (`SecurityConfig`).
4. Viene renderizzata `templates/login.html`, che carica `login.js`.

## 2) Invio credenziali
1. In `login.js`, al submit del form viene bloccato il post classico HTML.
2. Il frontend invia `POST /api/auth/login` con JSON:
   ```json
   { "username": "...", "password": "..." }
   ```
3. Endpoint gestito da `AuthController.login(...)`.

## 3) Autenticazione utente
1. `AuthController` chiama `AuthenticationManager.authenticate(...)`.
2. `AuthenticationManager` usa `CustomUserDetailsService.loadUserByUsername(...)` per leggere l'utente da DB tramite `UserRepository`.
3. Spring Security confronta password inserita vs password DB usando `PasswordEncoder` configurato in `SecurityConfig` (`BCryptPasswordEncoder`).
4. Se credenziali non valide: risposta di errore (frontend mostra box errore).
5. Se credenziali valide: autenticazione riuscita.

## 4) Emissione token JWT
1. `AuthController` chiama `JwtService.generateToken(...)`.
2. `JwtService` crea JWT con:
   - `sub` = username
   - `iss` = issuer da `application.yaml`
   - `exp` = scadenza (`jwt.expiration-ms`)
   - claim `roles`
3. `AuthController` restituisce:
   - body JSON con `token`, `tokenType`, `expiresInMs`
   - cookie `AUTH_TOKEN` (HttpOnly) con il JWT
4. Il browser salva anche il token in `localStorage` (da `login.js`) e va su `/home`.

## 5) Accesso alle pagine protette
1. Qualsiasi rotta non in `permitAll` richiede autenticazione (`anyRequest().authenticated()`).
2. Per ogni richiesta, passa `JwtAuthenticationFilter`:
   - cerca prima `Authorization: Bearer <token>`
   - se assente, cerca cookie `AUTH_TOKEN`
3. Se il token è valido:
   - estrae username
   - ricarica utente da DB
   - popola `SecurityContext`
   - la richiesta continua come autenticata
4. Se token mancante/non valido:
   - richiesta resta anonima
   - Spring Security attiva l'entry point e manda verso `/login`.

## 6) Logout
- `POST /api/auth/logout` (AuthController): invalida il cookie `AUTH_TOKEN` lato browser (`maxAge=0`).
- In più è configurato anche `/logout` in `SecurityConfig` con cancellazione cookie.

---

## Schema rapido (ASCII)

```text
[Browser] --GET /--> [LogInController] --redirect--> /login
   |
   v
login.html + login.js
   |
   | submit
   v
POST /api/auth/login (JSON username/password)
   |
   v
[AuthController] --> [AuthenticationManager]
                     --> [CustomUserDetailsService] --> [UserRepository] --> [DB utenze]
                     --> [PasswordEncoder BCrypt check]
   |
   | OK
   v
[JwtService] -> crea JWT (sub, iss, exp, roles)
   |
   v
Set-Cookie AUTH_TOKEN + body {token}
   |
   v
GET /home (o altre route protette)
   |
   v
[JwtAuthenticationFilter] legge Bearer o cookie -> valida JWT -> SecurityContext
   |
   +--> valido: accesso
   +--> non valido/assente: redirect /login
```

## Note operative
- L'app e' stateless (`SessionCreationPolicy.STATELESS`): la sessione server non viene usata.
- Oggi il token viene salvato sia in cookie HttpOnly che in `localStorage`.
- Per API pure (futuro Angular), spesso si preferisce una strategia unica di trasporto token (solo cookie o solo Bearer header).

