package com.boffa.project.mapper;

import com.boffa.project.dto.PlayerDto;
import com.boffa.project.entity.PlayerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerMapper {

    public List<PlayerDto> createDtoListFromEntityList(List<PlayerEntity> entityList) {
        return entityList.stream()
                .map(this::createDtoFromEntity)
                .toList();
    }

    public PlayerDto createDtoFromEntity(PlayerEntity e) {
        PlayerDto dto = new PlayerDto();
        if (e != null) {
            dto.setId(e.getId());
            dto.setAnagraficaId(e.getAnagrafica().getId());
            dto.setSquadraId(e.getSquadra().getId());
            dto.setRuoloId(e.getRuolo().getId());
            dto.setValore(e.getValore());
            dto.setGoal(e.getGoal());
            dto.setUserName(e.getUserName());
        }
        return dto;
    }
}
