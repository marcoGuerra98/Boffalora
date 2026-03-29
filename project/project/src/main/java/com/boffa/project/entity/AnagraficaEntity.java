package com.boffa.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anagrafica")
public class AnagraficaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "codice_fiscale", nullable = false, unique = true, length = 16)
    private String codiceFiscale;

    @Column(name = "indirizzo", nullable = false, length = 100)
    private String indirizzo;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate data_nascita;

    @Column(name = "citta", nullable = false, length = 50)
    private String citta;

    @Column(name = "cap", nullable = false, length = 5)
    private String cap;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
}
