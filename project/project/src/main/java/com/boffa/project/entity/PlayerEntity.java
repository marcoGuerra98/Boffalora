package com.boffa.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "giocatore")
public class PlayerEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anagrafica_id", nullable = false)
    private AnagraficaEntity anagrafica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squadra_id", nullable = false)
    private SquadraEntity squadra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", nullable = false)
    private RoleEntity ruolo;

    @Column(name = "valore")
    private Integer valore;

    @Column(name = "goal")
    private Integer goal;

    @Column(name = "user_name")
    private String userName;


}
