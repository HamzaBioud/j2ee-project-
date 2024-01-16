package com.example.gestionpharmacie.web;

import com.example.gestionpharmacie.dao.entities.Vendeur;

import java.util.List;

public interface IVendeurRestController {

    Vendeur save(Vendeur vendeur);

    Vendeur getVendeurById(Long id);

    List<Vendeur> getAllVendeur();
    Vendeur updateVendeur(Vendeur vendeur,Long id);
}
