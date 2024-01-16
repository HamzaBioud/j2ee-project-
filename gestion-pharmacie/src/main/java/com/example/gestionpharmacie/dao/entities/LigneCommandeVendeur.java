package com.example.gestionpharmacie.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneCommandeVendeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommandePatient;
    @ManyToOne
    @JoinColumn(name = "idMedicament")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "idcommandeVendeur")
    @JsonIgnore
    private CommandeVendeur commandeVendeur;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;
    @Override
    public String toString() {
        return "LigneCommandeVendeur{" +
                "idLigneCommandePatient=" + idLigneCommandePatient +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }
}
