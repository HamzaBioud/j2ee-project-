package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendeurRepository extends JpaRepository<Vendeur,Long> {
}
