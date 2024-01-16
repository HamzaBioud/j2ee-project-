package com.example.gestionpharmacie.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String prenom;

    private String nom;

    private String phone;

    private String cin;

    private Date dateNaissance;

    public Patient(String prenom, String nom, String phone, String cin) {
        this.prenom = prenom;
        this.nom = nom;
        this.phone = phone;
        this.cin = cin;
    }
}
