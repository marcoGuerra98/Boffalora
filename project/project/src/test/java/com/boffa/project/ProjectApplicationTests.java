package com.boffa.project;

import com.boffa.project.config.SecurityConfig;
import com.boffa.project.entity.UserEntity;
import com.boffa.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	SecurityConfig securityConfig;

	@Test
	void contextLoads() {
	}

	/**
	 * ============================================
	 * TEST DI CONNESSIONE AL DATABASE
	 * ============================================
	 */

	/**
	 * Test 1: Verifica connessione di base al DB
	 */
	@Test
	void testDatabaseConnection() {
		System.out.println("\n╔════════════════════════════════════════════════════════════╗");
		System.out.println("║ TEST 1: Verifica Connessione al Database                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝\n");

		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();

			System.out.println("✅ CONNESSIONE RIUSCITA!");
			System.out.println("   Database URL: " + metaData.getURL());
			System.out.println("   Database Driver: " + metaData.getDriverName());
			System.out.println("   Database Version: " + metaData.getDatabaseProductVersion());
			System.out.println("   Username: " + metaData.getUserName());

			connection.close();
			System.out.println("\n✅ Connessione chiusa correttamente\n");
		} catch (Exception e) {
			System.out.println("❌ ERRORE DI CONNESSIONE!");
			System.out.println("   Messaggio: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Test 2: Verifica che la tabella UTENZE esista
	 */
	@Test
	void testTableExists() {
		System.out.println("\n╔════════════════════════════════════════════════════════════╗");
		System.out.println("║ TEST 2: Verifica Esistenza Tabella UTENZE                   ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝\n");

		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();

			// Cerca la tabella UTENZE
			var tables = metaData.getTables(null, null, "UTENZE", new String[]{"TABLE"});

			if (tables.next()) {
				System.out.println("✅ TABELLA TROVATA!");
				System.out.println("   Nome Tabella: " + tables.getString("TABLE_NAME"));
				System.out.println("   Tipo: " + tables.getString("TABLE_TYPE"));
				System.out.println("   Catalogo: " + tables.getString("TABLE_CAT"));
				System.out.println();

				// Mostra i colonne della tabella
				System.out.println("📋 Colonne della tabella:");
				var columns = metaData.getColumns(null, null, "UTENZE", null);
				while (columns.next()) {
					System.out.println("   - " + columns.getString("COLUMN_NAME") +
							" (" + columns.getString("TYPE_NAME") + ")");
				}
			} else {
				System.out.println("❌ TABELLA NON TROVATA!");
				System.out.println("   La tabella 'UTENZE' non esiste nel database");
				System.out.println("\n   ℹ️  Tabelle disponibili:");
				var allTables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
				while (allTables.next()) {
					System.out.println("      - " + allTables.getString("TABLE_NAME"));
				}
			}

			connection.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println("❌ ERRORE!");
			System.out.println("   " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Test 3: Test JPA Repository - findAll()
	 */
	@Test
	void testJPAFindAll() {
		System.out.println("\n╔════════════════════════════════════════════════════════════╗");
		System.out.println("║ TEST 3: JPA Repository - findAll()                          ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝\n");

		try {
			List<UserEntity> allUsers = userRepository.findAll();
			System.out.println("✅ Query JPA eseguita!");
			System.out.println("   userRepository.findAll() = " + allUsers.size() + " record(s)");

			if (allUsers.isEmpty()) {
				System.out.println("   ⚠️  Repository non ha trovato nessun utente!");
				System.out.println("\n   Possibili cause:");
				System.out.println("   1. La tabella non contiene dati");
				System.out.println("   2. Hibernate non sta mappando la tabella correttamente");
				System.out.println("   3. Il nome della tabella è diverso da 'UTENZE'");
			} else {
				System.out.println("   ✅ Trovati " + allUsers.size() + " utente(i)");
				for (int i = 0; i < allUsers.size(); i++) {
					UserEntity u = allUsers.get(i);
					System.out.println("   " + (i + 1) + ") ID=" + u.getId() +
							" | User=" + u.getUserName() +
							" | Email=" + u.getEmail() +
							" | Ruolo=" + u.getRuolo() +
							" | Password=" + u.getPassword());
				}
			}

			System.out.println();
		} catch (Exception e) {
			System.out.println("❌ ERRORE JPA!");
			System.out.println("   " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Test 4: Debug findByNomeUtente('marco')
	 */
	@Test
	@Transactional
	void testFindByNomeUtente_Marco() {
		System.out.println("\n╔════════════════════════════════════════════════════════════╗");
		System.out.println("║ TEST 4: findByNomeUtente('marco') [@Transactional]         ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝\n");


		// 1. Prova a trovare "marco"
		System.out.println("🔍 Cercando: findByNomeUtente('marco')...");
		UserEntity marcoResult = userRepository.findByUserName("marco");

		if (marcoResult != null) {
			UserEntity marco = marcoResult;
			System.out.println("✅ TROVATO!");
			System.out.println("  ID: " + marco.getId());
			System.out.println("  Nome Utente: '" + marco.getUserName() + "'");
			System.out.println("  Email: " + marco.getEmail());
			System.out.println("  Password hash: " + marco.getPassword());
			System.out.println("  Ruolo: " + marco.getRuolo());
			System.out.println("  Attivo: " + marco.getAttivo());
		} else {
			System.out.println("❌ NON TROVATO");
		}

		// 2. Prova anche gli altri utenti
		System.out.println("\n🔍 Cercando: findByNomeUtente('mario.rossi')...");
		UserEntity marioResult = userRepository.findByUserName("mario.rossi");
		if (marioResult != null) {
			System.out.println("✅ mario.rossi trovato");
		} else {
			System.out.println("❌ mario.rossi non trovato");
		}

		System.out.println("\n=== FINE TEST ===\n");
	}

	@Test
	void createPasswordHash() {
		String password = "manfredonia";
		String hashedPassword = org.springframework.security.crypto.bcrypt.BCrypt.hashpw(password, org.springframework.security.crypto.bcrypt.BCrypt.gensalt());
		String hashedPassword2 = securityConfig.passwordEncoder().encode(password);
		System.out.println("Password originale: " + password);
		System.out.println("Password hashata: " + hashedPassword);
		System.out.println("Password hashata (via SecurityConfig): " + hashedPassword2);
	}

	@Test
	void testPasswordEncoder() {
		UserEntity marcoResult = userRepository.findByUserName("marco");
		String password = "manfredonia";
		String encodedPassword = securityConfig.passwordEncoder().encode(password);

		String storedPassword = marcoResult.getPassword();
		String storredPassword2 = securityConfig.passwordEncoder().encode(storedPassword);

		boolean matches = securityConfig.passwordEncoder().matches(encodedPassword, storredPassword2);
		System.out.println("Password originale: " + password);
		System.out.println("Password hashata (dal DB): " + marcoResult.getPassword());
		System.out.println("Password hashata (nuova): " + encodedPassword);
		System.out.println("La password originale corrisponde a quella hashata dal DB? " + matches);
	}

}
