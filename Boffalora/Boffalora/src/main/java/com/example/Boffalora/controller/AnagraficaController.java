package com.example.Boffalora.controller;

import com.example.Boffalora.dao.AnagraficaRepository;
import com.example.Boffalora.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anagrafica")
public class AnagraficaController {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @GetMapping
    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaRepository.findAll();
    }

}
