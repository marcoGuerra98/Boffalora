package com.example.Boffalora.service;

import com.example.Boffalora.dao.AnagraficaRepository;
import com.example.Boffalora.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaServiceImpl { // Nessuna interfaccia implementata

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaRepository.findAll();
    }
}
