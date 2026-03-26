package com.boffa.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String userName;
    private String email;
    private String ruolo;
    private Boolean attivo;
    private LocalDateTime dataCreazione;
    private LocalDate dataScadenza;
    private LocalDateTime ultimoAccesso;
    private Integer tentativiLogin;
}
