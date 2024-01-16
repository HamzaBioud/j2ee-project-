package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
