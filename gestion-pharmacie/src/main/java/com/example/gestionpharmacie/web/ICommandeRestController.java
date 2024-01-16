package com.example.gestionpharmacie.web;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.CommandeVendeur;
import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;
import com.example.gestionpharmacie.dao.entities.LigneCommandeVendeur;

import java.util.List;

public interface ICommandeRestController {
    CommandePatient saveCommandePatient(CommandePatient commandePatient);
    List<CommandePatient> findAllCommandesPatient();
    CommandePatient findCommandePatientById(Long id);
    CommandeVendeur saveCommandeVendeur(CommandeVendeur commandeVendeur);
    List<CommandeVendeur> findAllCommandeVendeur();
    CommandeVendeur findCommandeVendeurById(Long id);
    List<LigneCommandeVendeur> findAllLigneCommandeVendeur(Long id);
    List<LigneCommandePatient> findAllLigneCommandePatient(Long id);
}
