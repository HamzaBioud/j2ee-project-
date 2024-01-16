package com.example.gestionpharmacie.metier.ServiceImpl;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.CommandeVendeur;
import com.example.gestionpharmacie.dao.entities.LigneCommandeVendeur;
import com.example.gestionpharmacie.dao.repositories.CommandePatientRepository;
import com.example.gestionpharmacie.dao.repositories.CommandeVendeurRepository;
import com.example.gestionpharmacie.dao.repositories.LigneCommandeVendeurRepository;
import com.example.gestionpharmacie.metier.CommandeVendeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeVendeurServiceImpl implements CommandeVendeurService{
    @Autowired
    private CommandeVendeurRepository commandeVendeurRepository;
    @Autowired
    private LigneCommandeVendeurRepository ligneCommandeVendeurRepository;
    @Override
    public CommandeVendeur saveCommande(CommandeVendeur commande) {
        commande.setDateCommande(LocalDate.now());
        CommandeVendeur cmd = commandeVendeurRepository.save(commande);
        if(commande.getLigneCommandeVendeurs()!=null){
            commande.getLigneCommandeVendeurs().forEach(ligneCommandeVendeur -> {
                ligneCommandeVendeur.setCommandeVendeur(cmd);
                ligneCommandeVendeurRepository.save(ligneCommandeVendeur);
            });
        }

        return commandeVendeurRepository.save(commande);
    }

    @Override
    public List<CommandeVendeur> findAllCommandes() {
        return commandeVendeurRepository.findAll();
    }

    @Override
    public CommandeVendeur findCommandeById(Long id) {
        return commandeVendeurRepository.findById(id).orElseThrow();
    }

    @Override
    public List<LigneCommandeVendeur> findAllLigneCommandeVendeur(Long id) {
        return ligneCommandeVendeurRepository.findAllByCommandeVendeurIdCommande(id);
    }
}
