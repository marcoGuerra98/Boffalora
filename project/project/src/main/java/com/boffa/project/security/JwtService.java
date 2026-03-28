package com.boffa.project.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final JwtProperties jwtProperties;

    public JwtService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String generateToken(UserDetails userDetails) {
        Instant now = Instant.now();
        Instant expiresAt = now.plusMillis(jwtProperties.getExpirationMs());
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return JWT.create()
                .withIssuer(jwtProperties.getIssuer())
                .withSubject(userDetails.getUsername())
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(expiresAt))
                .withClaim("roles", roles)
                .sign(algorithm());
    }

    public String extractUsername(String token) {
        return verify(token).getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = verify(token).getExpiresAt();
        return expiration == null || expiration.before(new Date());
    }

    private DecodedJWT verify(String token) {
        return JWT.require(algorithm())
                .withIssuer(jwtProperties.getIssuer())
                .build()
                .verify(token);
    }

    private Algorithm algorithm() {
        return Algorithm.HMAC256(jwtProperties.getSecret());
    }
}
