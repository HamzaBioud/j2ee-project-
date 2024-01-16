package com.example.gestionpharmacie.metier;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;

import java.util.List;

public interface CommandePatientService {
    CommandePatient saveCommande(CommandePatient commande);
    List<CommandePatient> findAllCommandes();
    CommandePatient findCommandeById(Long id);
    List<LigneCommandePatient> findAllLigneCommandePatient(Long id);
}
