package com.example.gestionpharmacie.web.ControllerImpl;

import com.example.gestionpharmacie.dao.entities.Patient;
import com.example.gestionpharmacie.metier.IPatientService;
import com.example.gestionpharmacie.web.IPatientRestContoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin("*")
public class PatientController implements IPatientRestContoller {
    @Autowired
    private IPatientService iPatientService;
    @PostMapping("/")
    @Override
    public Patient save(@RequestBody Patient patient) {
        return iPatientService.save(patient);
    }
    @GetMapping("/{id}")
    @Override
    public Patient getPatientById(@PathVariable("id") Long id) {
        return iPatientService.getPatientById(id);
    }
    @GetMapping("/all")
    @Override
    public List<Patient> getAllPatient() {
        return iPatientService.getAllPatient();
    }

    @PutMapping("/{id}")
    @Override
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable Long id) {
        return iPatientService.updatePatient(patient,id);
    }
}
