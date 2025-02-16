package com.example.Boffalora.controller;


import com.example.Boffalora.bean.AnagraficaBean;
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

    @GetMapping("/getAllAnagrafica")
    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaService.getAllAnagrafica();
    }


    @PostMapping("/setAnagrafica")
    public void setAnagrafica(@RequestBody AnagraficaBean bean) {
        anagraficaService.setAnagraficaToDB(bean);
    }

}
