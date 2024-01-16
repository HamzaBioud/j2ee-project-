package com.example.gestionpharmacie.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendeur;
    private String prenom;
    private String nom;
    private String phoneNumber;
    private String email;
//    @JsonIgnore
//    @OneToMany(mappedBy = "vendeur",fetch = FetchType.LAZY)
//    private List<CommandeVendeur> commandes;


    public Vendeur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public Vendeur(String prenom, String nom, String phoneNumber, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
