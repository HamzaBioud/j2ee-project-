package com.example.gestionpharmacie.metier;

import com.example.gestionpharmacie.dao.entities.Patient;

import java.util.List;

public interface IPatientService {
    Patient save(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatient();
    Patient updatePatient(Patient patient , Long id);
}
