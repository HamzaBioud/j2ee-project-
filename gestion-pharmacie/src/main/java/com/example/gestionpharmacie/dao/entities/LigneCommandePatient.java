package com.example.gestionpharmacie.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneCommandePatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommandePatient;
    @ManyToOne
    @JoinColumn(name = "idMedicament")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "idcommandePatient")
    @JsonIgnore
    private CommandePatient commandePatient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Override
    public String toString() {
        return "LigneCommandePatient{" +
                "idLigneCommandePatient=" + idLigneCommandePatient +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }
}
