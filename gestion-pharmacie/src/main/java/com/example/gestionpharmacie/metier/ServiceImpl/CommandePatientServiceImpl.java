package com.example.gestionpharmacie.metier.ServiceImpl;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;
import com.example.gestionpharmacie.dao.repositories.CommandePatientRepository;
import com.example.gestionpharmacie.dao.repositories.LigneCommandePatientRepository;
import com.example.gestionpharmacie.metier.CommandePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
@Service
public class CommandePatientServiceImpl implements CommandePatientService {
    @Autowired
    private CommandePatientRepository commandePatientRepository;
    @Autowired
    private LigneCommandePatientRepository ligneCommandePatientRepository;
    @Override
    public CommandePatient saveCommande(CommandePatient commande) {

        commande.setDateCommande(LocalDate.now());

        CommandePatient cmd = commandePatientRepository.save(commande);

        if(commande.getLigneCommandePatients()!=null){
            commande.getLigneCommandePatients().forEach(ligneCommandePatient->{
                ligneCommandePatient.setCommandePatient(cmd);
                ligneCommandePatientRepository.save(ligneCommandePatient);
            });
        }

        return commandePatientRepository.save(commande);
    }

    @Override
    public List<CommandePatient> findAllCommandes() {
        return commandePatientRepository.findAll();
    }

    @Override
    public CommandePatient findCommandeById(Long id) {
        return commandePatientRepository.findById(id).orElseThrow();
    }

    @Override
    public List<LigneCommandePatient> findAllLigneCommandePatient(Long id) {
        return ligneCommandePatientRepository.findAllByCommandePatientIdCommande(id);
    }
}
