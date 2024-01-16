package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandePatientRepository extends JpaRepository<LigneCommandePatient,Long> {
    List<LigneCommandePatient>  findAllByCommandePatientIdCommande(Long id);
}
