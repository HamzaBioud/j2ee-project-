package com.example.gestionpharmacie.dao.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicament;
    private String nom;
    private String code;
    private BigDecimal prix;

    @OneToMany(mappedBy = "medicament")
    @XmlTransient
    @JsonIgnore
    private List<LigneCommandePatient> ligneCommandePatients;
    @OneToMany(mappedBy = "medicament")
    @XmlTransient
    @JsonIgnore
    private List<LigneCommandeVendeur> ligneCommandeVendeurs;

    public Medicament(String nom, String code, BigDecimal prix) {
        this.nom = nom;
        this.code = code;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "idMedicament=" + idMedicament +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", prix=" + prix +
                '}';
    }
}
