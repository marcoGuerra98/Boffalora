package com.boffa.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnagraficaDto {

    private Integer id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String indirizzo;
    private LocalDate dataNascita;
    private String citta;
    private String cap;
    private String telefono;
    private String email;
}
