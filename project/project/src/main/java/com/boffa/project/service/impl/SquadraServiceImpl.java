package com.boffa.project.service.impl;

import com.boffa.project.dto.SquadraDto;
import com.boffa.project.entity.SquadraEntity;
import com.boffa.project.mapper.SquadraMapper;
import com.boffa.project.repository.SquadraRepository;
import com.boffa.project.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadraServiceImpl implements SquadraService {

    @Autowired
    SquadraRepository squadraRepository;

    @Autowired
    SquadraMapper squadraMapper;


    @Override
    public SquadraDto getSquadraByName(String name) {
        if (name != null) {
            SquadraEntity squadraEntity = squadraRepository.findByName(name);
            if (squadraEntity != null) {
                return squadraMapper.createSquadraDtoFromEntity(squadraEntity);
            }
        }
        return null;
    }

    @Override
    public boolean createTeam(String name) {
        if (name != null) {
            if (!squadraRepository.findNmeByName(name)) {
                SquadraEntity squadraEntity = new SquadraEntity(name);
                SquadraEntity save = squadraRepository.save(squadraEntity);
                return save.getId() != null;
            }
        }
        return false;
    }

    @Override
    public List<SquadraDto> allTeams() {
        List<SquadraEntity> squadre = squadraRepository.findAll();
        if (!squadre.isEmpty()) {
            return squadraMapper.createSquadraDtoListFromEntityList(squadre);
        }
        return List.of();
    }
}
