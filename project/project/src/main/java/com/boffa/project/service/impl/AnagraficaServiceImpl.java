package com.boffa.project.service.impl;

import com.boffa.project.dto.AnagraficaDto;
import com.boffa.project.entity.AnagraficaEntity;
import com.boffa.project.mapper.AnagraficaMapper;
import com.boffa.project.repository.AnagraficaRepository;
import com.boffa.project.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {

    @Autowired
    AnagraficaRepository anagraficaRepository;

    @Autowired
    AnagraficaMapper anagraficaMapper;

    @Override
    public List<AnagraficaDto> findAll() {
        List<AnagraficaEntity> entityList = anagraficaRepository.findAll();
        return anagraficaMapper.createDtoListFromEntityList(entityList);
    }
}
