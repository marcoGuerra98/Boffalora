package com.example.Boffalora.controller;


import com.example.Boffalora.model.Anagrafica;
import com.example.Boffalora.service.AnagraficaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anagrafica")
public class AnagraficaController {

    @Autowired
    private AnagraficaServiceImpl anagraficaService;

    @GetMapping
    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaService.getAllAnagrafica();
    }

}
