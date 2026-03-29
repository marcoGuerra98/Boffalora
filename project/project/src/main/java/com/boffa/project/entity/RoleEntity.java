package com.boffa.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ruolo")
public class RoleEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valore", length = 3)
    private String valore;

    @Column(name = "descrizione", length = 90)
    private String descrizione;
}
