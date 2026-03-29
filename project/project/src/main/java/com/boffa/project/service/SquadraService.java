package com.boffa.project.service;

import com.boffa.project.dto.SquadraDto;

import java.util.List;

public interface SquadraService {

    SquadraDto getSquadraByName(String name);

    boolean createTeam(String name);

    List<SquadraDto> allTeams();
}
