package com.example.gestionpharmacie.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    @ManyToOne
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    private int quantite;

}
