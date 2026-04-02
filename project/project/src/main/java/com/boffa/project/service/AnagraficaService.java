package com.boffa.project.service;

import com.boffa.project.dto.AnagraficaDto;

import java.util.List;

public interface AnagraficaService {

    List<AnagraficaDto> findAll();

    Integer insertNewAnag(AnagraficaDto dto);
}
