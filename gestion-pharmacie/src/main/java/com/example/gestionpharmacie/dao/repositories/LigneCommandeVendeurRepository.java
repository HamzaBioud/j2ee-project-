package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.LigneCommandeVendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeVendeurRepository extends JpaRepository<LigneCommandeVendeur,Long> {
    List<LigneCommandeVendeur> findAllByCommandeVendeurIdCommande(Long id);
}
