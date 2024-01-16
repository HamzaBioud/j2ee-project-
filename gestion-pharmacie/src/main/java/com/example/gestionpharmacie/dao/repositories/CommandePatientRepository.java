package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandePatientRepository extends JpaRepository<CommandePatient,Long> {
}
