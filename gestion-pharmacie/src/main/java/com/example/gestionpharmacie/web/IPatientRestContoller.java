package com.example.gestionpharmacie.web;

import com.example.gestionpharmacie.dao.entities.Patient;
import java.util.List;

public interface IPatientRestContoller {

    Patient save( Patient patient);

    Patient getPatientById( Long id);

    List<Patient> getAllPatient();
    Patient updatePatient(Patient patient , Long id);
}
