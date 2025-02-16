package com.example.Boffalora.controller;


import com.example.Boffalora.bean.AnagraficaBean;
import com.example.Boffalora.bean.AnagraficaResponseBean;
import com.example.Boffalora.model.Anagrafica;
import com.example.Boffalora.service.AnagraficaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anagrafica")
public class AnagraficaController {

    @Autowired
    private AnagraficaServiceImpl anagraficaService;

    @GetMapping("/getAllAnagrafica")
    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaService.getAllAnagrafica();
    }


    @PostMapping("/setAnagrafica")
    public ResponseEntity<AnagraficaResponseBean> setAnagrafica(@RequestBody AnagraficaBean bean) {
        try {
            anagraficaService.setAnagraficaToDB(bean);
            AnagraficaResponseBean response = new AnagraficaResponseBean("Anagrafica inserita con successo", null);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            AnagraficaResponseBean response = new AnagraficaResponseBean(null, "Errore durante l'inserimento dell'anagrafica: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
