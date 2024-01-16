package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
