package com.boffa.project.controller;

import com.boffa.project.dto.PlayerDto;
import com.boffa.project.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDto>> getAll() {
        List<PlayerDto> response = playerService.findAll();
        return ResponseEntity.ok().body(response);
    }


}
