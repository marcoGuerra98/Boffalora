package com.example.Boffalora.dao;

import com.example.Boffalora.model.Anagrafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaRepository extends JpaRepository<Anagrafica, Integer> {
    // Qui puoi aggiungere metodi personalizzati, se necessario
}
