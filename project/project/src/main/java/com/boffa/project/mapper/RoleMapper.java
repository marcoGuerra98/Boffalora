package com.boffa.project.mapper;

import com.boffa.project.dto.RoleDto;
import com.boffa.project.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMapper {

    public List<RoleDto> createDtoListFromEntityList(List<RoleEntity> entities) {
        return entities.stream().map(this::createDtoFromEntity).toList();
    }

    public RoleDto createDtoFromEntity(RoleEntity e) {
        RoleDto dto = new RoleDto();
        if (e != null) {
            dto.setId(e.getId());
            dto.setValore(e.getValore());
            dto.setDescrizione(e.getDescrizione());
        }
        return dto;
    }
}
