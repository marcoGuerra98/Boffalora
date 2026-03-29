package com.boffa.project;

import com.boffa.project.dto.UserDto;
import com.boffa.project.entity.AnagraficaEntity;
import com.boffa.project.entity.SquadraEntity;
import com.boffa.project.entity.UserEntity;
import com.boffa.project.mapper.UserMapper;
import com.boffa.project.repository.AnagraficaRepository;
import com.boffa.project.repository.SquadraRepository;
import com.boffa.project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@Transactional
public class TestDTO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Autowired
    private SquadraRepository squadraRepository;

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

    @Test
    void testAnagraficaEntity() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ TEST AnagraficaEntity: Verifica AnagraficaEntity         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Qui potresti creare un'istanza di AnagraficaEntity, popolarla con dati di test
        // e verificare che i getter/setter funzionino correttamente.
        // Ad esempio:

        String input = "1998-04-12 10:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);


        AnagraficaEntity anagrafica = new AnagraficaEntity();
        anagrafica.setNome("Marco");
        anagrafica.setCognome("Guerra");
        anagrafica.setCodiceFiscale("GRRMRC98D12E648Q");
        anagrafica.setData_nascita(dateTime.toLocalDate());
        anagrafica.setIndirizzo("Via Aldo Moro 8");
        anagrafica.setCitta("Boffalora d'Adda");
        anagrafica.setCap("26811");
        anagrafica.setTelefono("3661994461");
        anagrafica.setEmail("marcoguerra098@gmail.com");

        AnagraficaEntity salvata = anagraficaRepository.save(anagrafica);

        if (salvata.getId() != null) {
            System.out.println("✅ AnagraficaEntity salvata correttamente con ID: " + salvata.getId());
        } else {
            System.out.println("❌ ERRORE: AnagraficaEntity non salvata correttamente");
        }
    }

    @Test
    void testExtractAllAnagrafiche() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ TEST Extract All Anagrafiche: Verifica estrazione         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Qui potresti testare l'estrazione di tutte le anagrafiche dal database
        // e verificare che i dati siano corretti.
        // Ad esempio:

        List<AnagraficaEntity> anagrafiche = anagraficaRepository.findAll();
        if (!anagrafiche.isEmpty()) {
            System.out.println("✅ Anagrafiche estratte correttamente:");
            anagrafiche.forEach(a -> System.out.println("   " + a.getNome() + " " + a.getCognome()));
        } else {
            System.out.println("❌ ERRORE: Nessuna anagrafica trovata");
        }

    }

    @Test
    @Rollback(false) // Rimuovi questa annotazione se vuoi che il test venga rollbackato dopo l'esecuzione
    void insertIntoSquadra() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ TEST Insert Into Squadra: Verifica inserimento squadra     ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Qui potresti testare l'inserimento di una nuova squadra nel database
        // e verificare che l'inserimento sia avvenuto correttamente.
        // Ad esempio:

         SquadraEntity squadra = new SquadraEntity();
         squadra.setName("Juventus");
         squadra.setVittorie(0);
         squadra.setSconfitte(0);
         squadra.setPareggi(0);
         squadra.setPunti(0);
         squadra.setGoalFatti(0);
         squadra.setGoalSubiti(0);

         SquadraEntity salvata = squadraRepository.save(squadra);


         if (salvata.getId() != null) {
             System.out.println("✅ Squadra salvata correttamente con ID: " + salvata.getId());
             System.out.println(" Punti: " + salvata.getPunti());
             System.out.println(" Vittorie: " + salvata.getVittorie());
             System.out.println(" Sconfitte: " + salvata.getSconfitte());
             System.out.println(" Pareggi: " + salvata.getPareggi());
         } else {
             System.out.println("❌ ERRORE: Squadra non salvata correttamente");
         }
    }
}
