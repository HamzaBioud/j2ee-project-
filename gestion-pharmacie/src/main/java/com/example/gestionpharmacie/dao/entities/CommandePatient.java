package com.example.gestionpharmacie.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private LocalDate dateCommande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;


    @OneToOne(mappedBy = "commande")
    private Facture facture;
    @OneToMany(mappedBy = "commandePatient")
    private List<LigneCommandePatient> ligneCommandePatients;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
