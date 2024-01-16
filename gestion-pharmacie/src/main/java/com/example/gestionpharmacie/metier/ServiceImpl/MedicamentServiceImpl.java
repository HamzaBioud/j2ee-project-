package com.example.gestionpharmacie.metier.ServiceImpl;


import com.example.gestionpharmacie.dao.entities.Medicament;
import com.example.gestionpharmacie.dao.repositories.MedicamentRepository;
import com.example.gestionpharmacie.metier.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicamentServiceImpl implements MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Override
    public Medicament saveMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public List<Medicament> getAllMedicament() {
        return medicamentRepository.findAll();
    }

    @Override
    public Medicament getMedicamentById(Long id) {
        return medicamentRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }

    @Override
    public Medicament updateMedicament(Medicament medicament, Long id) {
        Medicament medicament1 = medicamentRepository.findById(id).get();
        System.out.println(medicament1);
        if(medicament1.getIdMedicament()==null){
            throw new RuntimeException("patient exist pas");
        }
        medicament.setIdMedicament(medicament1.getIdMedicament());
        return medicamentRepository.save(medicament);
    }
}
