package com.boffa.project.mapper;

import com.boffa.project.dto.UserDto;
import com.boffa.project.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public List<UserDto> createUserEntityListFromDtoList(List<UserEntity> entityList) {
        List<UserDto> userDtoList = null;
        if (entityList != null && !entityList.isEmpty()) {
            for (UserEntity e : entityList) {
                assert false;
                userDtoList.add(createUserDtoFromEntity(e));
            }
        }
        return userDtoList;
    }


    public UserDto createUserDtoFromEntity(UserEntity userEntity) {

        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setRuolo(userEntity.getRuolo());
        userDto.setAttivo(userEntity.getAttivo());
        userDto.setDataCreazione(userEntity.getDataCreazione());
        userDto.setDataScadenza(userEntity.getDataScadenza());
        userDto.setUltimoAccesso(userEntity.getUltimoAccesso());
        userDto.setTentativiLogin(userEntity.getTentativiLogin());
        return userDto;
    }
}