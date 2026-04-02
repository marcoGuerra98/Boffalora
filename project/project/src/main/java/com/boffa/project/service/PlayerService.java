package com.boffa.project.service;

import com.boffa.project.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    List<PlayerDto> findAll();
}
