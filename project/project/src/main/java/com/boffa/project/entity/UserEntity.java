package com.boffa.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utenze")
public class UserEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_utente", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "ruolo", nullable = false, length = 20)
    private String ruolo;

    @Column(name = "attivo", nullable = false)
    private Boolean attivo;

    @Column(name = "data_creazione", nullable = false, updatable = false)
    private LocalDateTime dataCreazione;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @Column(name = "ultimo_accesso")
    private LocalDateTime ultimoAccesso;

    @Column(name = "tentativi_login", nullable = false)
    private Integer tentativiLogin;
}
