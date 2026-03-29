package com.boffa.project;

import com.boffa.project.entity.RoleEntity;
import com.boffa.project.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class TestRepository {

    @Autowired
    RoleRepository roleRepository;

    @Test
    void testRoleRepository() {
            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║ TEST REPOSITORY: Verifica RoleRepository                    ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝\n");

            // Qui potresti testare i metodi del RoleRepository, ad esempio:

            List<RoleEntity> roles = roleRepository.findAll();
            if (roles.isEmpty()) {
                System.out.println("Nessun ruolo trovato nel database.");
            } else {
                System.out.println("Ruoli trovati:");
                for (RoleEntity role : roles) {
                    System.out.println("- " + role.getValore() + ": " + role.getDescrizione());
                }
            }

    }
}
