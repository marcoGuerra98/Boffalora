package com.boffa.project.mapper;

import com.boffa.project.dto.SquadraDto;
import com.boffa.project.entity.SquadraEntity;
import org.springframework.stereotype.Component;

@Component
public class SquadraMapper {

    public SquadraDto createSquadraDtoFromEntity(SquadraEntity squadraEntity) {
        if (squadraEntity == null) {
            return null;
        }

        SquadraDto squadraDto = new SquadraDto();
        squadraDto.setId(squadraEntity.getId());
        squadraDto.setName(squadraEntity.getName());
        squadraDto.setPunti(squadraEntity.getPunti());
        squadraDto.setVittorie(squadraEntity.getVittorie());
        squadraDto.setSconfitte(squadraEntity.getSconfitte());
        squadraDto.setPareggi(squadraEntity.getPareggi());
        squadraDto.setGoalFatti(squadraEntity.getGoalFatti());
        squadraDto.setGoalSubiti(squadraEntity.getGoalSubiti());

        return squadraDto;
    }
}
