package com.boffa.project.mapper;

import com.boffa.project.dto.AnagraficaDto;
import com.boffa.project.entity.AnagraficaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class AnagraficaMapper {

    public List<AnagraficaDto> createDtoListFromEntityList(List<AnagraficaEntity> entities) {
        return entities.stream().map(this::createDtoFromEntity).toList();
    }

    public AnagraficaDto createDtoFromEntity(AnagraficaEntity entity) {
        if (entity != null) {
            AnagraficaDto dto = new AnagraficaDto();
            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setCognome(entity.getCognome());
            dto.setCodiceFiscale(entity.getCodiceFiscale());
            dto.setDataNascita(entity.getDataNascita());
            dto.setIndirizzo(entity.getIndirizzo());
            dto.setCitta(entity.getCitta());
            dto.setCap(entity.getCap());
            dto.setTelefono(entity.getTelefono());
            dto.setEmail(entity.getEmail());
            return dto;
        }
        return new AnagraficaDto();
    }

    public List<AnagraficaEntity> createEntityListFromDtoList(List<AnagraficaDto> dtos) {
        return dtos.stream().map(this::createEntityFromDto).toList();
    }

    public AnagraficaEntity createEntityFromDto(AnagraficaDto dto) {
        AnagraficaEntity e = new AnagraficaEntity();
        if (dto != null) {
            e.setNome(dto.getNome());
            e.setCognome(dto.getCognome());
            e.setCodiceFiscale(dto.getCodiceFiscale());
            e.setDataNascita(dto.getDataNascita());
            e.setIndirizzo(dto.getIndirizzo());
            e.setCitta(dto.getCitta());
            e.setCap(dto.getCap());
            e.setTelefono(dto.getTelefono());
            e.setEmail(dto.getEmail());
        }
        return e;
    }
}
