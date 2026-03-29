package com.boffa.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadraDto {

    private Integer id;
    private String nome;
    private Integer punti;
    private Integer vittorie;
    private Integer sconfitte;
    private Integer pareggi;
    private Integer goalFatti;
    private Integer goalSubiti;
}
