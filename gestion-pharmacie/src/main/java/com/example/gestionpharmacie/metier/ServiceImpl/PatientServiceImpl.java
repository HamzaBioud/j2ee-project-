package com.example.gestionpharmacie.metier.ServiceImpl;

import com.example.gestionpharmacie.dao.entities.Patient;
import com.example.gestionpharmacie.dao.repositories.PatientRepository;
import com.example.gestionpharmacie.metier.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("")
        );
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Patient patient, Long id) {
        Patient patient1 = patientRepository.findById(id).get();
        System.out.println(patient1);
        if(patient1.getIdPatient()==null){
            throw new RuntimeException("patient exist pas");
        }
        patient.setIdPatient(patient1.getIdPatient());
        return patientRepository.save(patient);
    }
}
