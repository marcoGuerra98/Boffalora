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
}
