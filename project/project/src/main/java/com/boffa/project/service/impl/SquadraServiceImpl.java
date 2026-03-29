package com.boffa.project.service.impl;

import com.boffa.project.dto.SquadraDto;
import com.boffa.project.entity.SquadraEntity;
import com.boffa.project.mapper.SquadraMapper;
import com.boffa.project.repository.SquadraRepository;
import com.boffa.project.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
