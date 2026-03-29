package com.boffa.project.repository;

import com.boffa.project.entity.AnagraficaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnagraficaRepository extends JpaRepository<AnagraficaEntity, Integer> {
    AnagraficaEntity findByNome(String nome);
    AnagraficaEntity findByCognome(String cognome);
    AnagraficaEntity findByCodiceFiscale(String codiceFiscale);
    AnagraficaEntity findByEmail(String email);
}
