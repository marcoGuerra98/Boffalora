package com.boffa.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PlayerDto {

    private Integer id;
    private Integer anagraficaId;
    private Integer squadraId;
    private Integer ruoloId;
    private Integer valore;
    private Integer goal;
    private String userName;
}
