package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Moyenne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmoy;

    private Double moyennevalue;

    @Enumerated(EnumType.STRING)
    private Periode periode;

    private String code;
    @ManyToOne
    @JoinColumn(name = "eleve_id") // Assurez-vous que ce nom est unique
    private Eleve eleve;



}