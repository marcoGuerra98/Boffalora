package com.boffa.project.controller;

import com.boffa.project.dto.SquadraDto;
import com.boffa.project.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }
}
