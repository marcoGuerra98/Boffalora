package com.boffa.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "squadra")
public class SquadraEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "punti", nullable = false)
    private Integer punti;

    @Column(name = "vittorie", nullable = false)
    private Integer vittorie;

    @Column(name = "sconfitte", nullable = false)
    private Integer sconfitte;

    @Column(name = "pareggi", nullable = false)
    private Integer pareggi;

    @Column(name = "goal_fatti", nullable = false)
    private Integer goalFatti;

    @Column(name = "goal_subiti", nullable = false)
    private Integer goalSubiti;

    public SquadraEntity(String name) {
        this.name = name;
        this.punti = 0;
        this.vittorie = 0;
        this.sconfitte = 0;
        this.pareggi = 0;
        this.goalFatti = 0;
        this.goalSubiti = 0;
    }
}
