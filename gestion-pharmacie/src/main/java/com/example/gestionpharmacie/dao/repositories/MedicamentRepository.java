package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
}
