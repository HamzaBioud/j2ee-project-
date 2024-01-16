package com.example.gestionpharmacie.metier;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.CommandeVendeur;
import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;
import com.example.gestionpharmacie.dao.entities.LigneCommandeVendeur;

import java.util.List;

public interface CommandeVendeurService {
    CommandeVendeur saveCommande(CommandeVendeur commande);
    List<CommandeVendeur> findAllCommandes();
    CommandeVendeur findCommandeById(Long id);
    List<LigneCommandeVendeur> findAllLigneCommandeVendeur(Long id);
}
