package com.example.gestionpharmacie.metier;

import com.example.gestionpharmacie.dao.entities.Vendeur;

import java.util.List;

public interface IVendeurService {
    Vendeur save(Vendeur vendeur);
    Vendeur getVendeurById(Long id);
    List<Vendeur> getAllVendeur();
    Vendeur updateVendeur(Vendeur vendeur , Long id);
}
