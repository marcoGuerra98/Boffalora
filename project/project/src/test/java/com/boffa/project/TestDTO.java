package com.boffa.project;

import com.boffa.project.dto.UserDto;
import com.boffa.project.entity.UserEntity;
import com.boffa.project.mapper.UserMapper;
import com.boffa.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Optional;

@SpringBootTest
public class TestDTO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Test
    void testUserDto() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ TEST DTO: Verifica UserDto                                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Qui potresti creare un'istanza di UserDto, popolarla con dati di test
        // e verificare che i getter/setter funzionino correttamente.
        // Ad esempio:
        /*
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setUserName("testuser");
        userDto.setEmail("
         */

        UserEntity marcoResult = userRepository.findByUserName("marco");

        UserDto marcoDto = userMapper.createUserDtoFromEntity(marcoResult);

        if (marcoDto != null) {
            System.out.println("✅ UserDto creato correttamente:");
            System.out.println("   ID: " + marcoDto.getId());
            System.out.println("   Username: " + marcoDto.getUserName());
            System.out.println("   Email: " + marcoDto.getEmail());
        } else {
            System.out.println("❌ ERRORE: UserDto è null");
        }

    }
}
