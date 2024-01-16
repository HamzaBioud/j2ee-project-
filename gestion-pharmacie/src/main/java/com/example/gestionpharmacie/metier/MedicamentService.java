package com.example.gestionpharmacie.metier;

import com.example.gestionpharmacie.dao.entities.Medicament;
import java.util.List;

public interface MedicamentService {
    Medicament saveMedicament(Medicament medicament);
    List<Medicament> getAllMedicament();
    Medicament getMedicamentById(Long id);
    Medicament updateMedicament(Medicament medicament , Long id);
}
