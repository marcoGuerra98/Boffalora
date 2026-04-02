package com.boffa.project.service.impl;

import com.boffa.project.dto.PlayerDto;
import com.boffa.project.entity.PlayerEntity;
import com.boffa.project.mapper.PlayerMapper;
import com.boffa.project.repository.PlayerRepository;
import com.boffa.project.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<PlayerDto> findAll() {
        List<PlayerEntity> entities = playerRepository.findAll();
        return new PlayerMapper().createDtoListFromEntityList(entities);
    }
}
