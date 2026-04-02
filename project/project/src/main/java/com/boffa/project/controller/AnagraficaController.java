package com.boffa.project.controller;

import com.boffa.project.dto.AnagraficaDto;
import com.boffa.project.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {

    @Autowired
    AnagraficaService anagraficaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AnagraficaDto>> getAll() {
        List<AnagraficaDto> dto = anagraficaService.findAll();
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/insertNewAnag")
    public ResponseEntity<Integer> insertNewAnag(
            @RequestBody AnagraficaDto dto) {
        Integer id = anagraficaService.insertNewAnag(dto);
        if (id != null) {
            return ResponseEntity.ok(id);
        }
        return null;
    }
}
