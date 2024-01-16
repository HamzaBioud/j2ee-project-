package com.example.gestionpharmacie.web.ControllerImpl;

import com.example.gestionpharmacie.dao.entities.Medicament;
import com.example.gestionpharmacie.metier.MedicamentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@WebService

public class MedicamentEndpoint {

    private MedicamentService medicamentService;

    public MedicamentEndpoint(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @WebMethod(operationName = "saveMedicament")
    public Medicament save(@WebParam Medicament medicament){
        return medicamentService.saveMedicament(medicament);
    }
    @WebMethod(operationName = "getAllMedicament")
    public List<Medicament> getAllMedicament(){
        return medicamentService.getAllMedicament();
    }
    @WebMethod(operationName = "getMedicamentByID")
    public Medicament getMedicament(@WebParam(name = "id") Long id){
        return medicamentService.getMedicamentById(id);
    }

}
