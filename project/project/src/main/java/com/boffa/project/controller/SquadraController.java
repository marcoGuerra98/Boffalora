package com.boffa.project.controller;

import com.boffa.project.dto.SquadraDto;
import com.boffa.project.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/squadra")
public class SquadraController {

    @Autowired
    SquadraService squadraService;


    @GetMapping("/{name}")
    public ResponseEntity<SquadraDto> getSquadra(
            @PathVariable String name) {
        SquadraDto dto = squadraService.getSquadraByName(name);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/createTeam")
    public ResponseEntity<String> createTeam(
            @RequestParam String name) {
        boolean created = squadraService.createTeam(name);
        if (created) {
            return ResponseEntity.ok("Squadra creata con successo");
        } else {
            return ResponseEntity.status(400).body("Errore nella creazione della squadra");
        }
    }

    @GetMapping("/allTeams")
    public ResponseEntity<List<SquadraDto>> allTeams() {
        List<SquadraDto> squadre = squadraService.allTeams();
        return ResponseEntity.ok(squadre);
    }
}
