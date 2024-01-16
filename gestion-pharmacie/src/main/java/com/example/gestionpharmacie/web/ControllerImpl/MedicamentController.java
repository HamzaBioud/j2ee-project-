package com.example.gestionpharmacie.web.ControllerImpl;

import com.example.gestionpharmacie.dao.entities.Medicament;
import com.example.gestionpharmacie.dao.entities.Patient;
import com.example.gestionpharmacie.metier.ServiceImpl.MedicamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/medicaments")
@CrossOrigin("*")
public class MedicamentController {
    @Autowired
    private MedicamentServiceImpl medicamentService;
    @PostMapping("/save")
    public Medicament save(@RequestBody Medicament medicament){
        return medicamentService.saveMedicament(medicament);
    }
    @GetMapping("")
    public List<Medicament> getAll(){
        return medicamentService.getAllMedicament();
    }
    @GetMapping("/{id}")
    public Medicament getById(@PathVariable Long id){
        return medicamentService.getMedicamentById(id);
    }
    @PutMapping("/{id}")
    public Medicament updateMedicament(@RequestBody Medicament medicament, @PathVariable Long id) {
        return medicamentService.updateMedicament(medicament,id);
    }
}
