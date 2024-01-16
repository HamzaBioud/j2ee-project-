package com.example.gestionpharmacie.web.ControllerImpl;

import com.example.gestionpharmacie.dao.entities.CommandePatient;
import com.example.gestionpharmacie.dao.entities.CommandeVendeur;
import com.example.gestionpharmacie.dao.entities.LigneCommandePatient;
import com.example.gestionpharmacie.dao.entities.LigneCommandeVendeur;
import com.example.gestionpharmacie.metier.CommandePatientService;
import com.example.gestionpharmacie.metier.CommandeVendeurService;
import com.example.gestionpharmacie.web.ICommandeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin("*")
public class CommandeController implements ICommandeRestController {
    @Autowired
    private CommandePatientService commandePatientService;
    @Autowired
    private CommandeVendeurService commandeVendeurService;

    @PostMapping("/patient/save")
    @Override
    public CommandePatient saveCommandePatient(@RequestBody CommandePatient commandePatient) {
        return commandePatientService.saveCommande(commandePatient);
    }

    @GetMapping("/patient/all")
    @Override
    public List<CommandePatient> findAllCommandesPatient() {
        return commandePatientService.findAllCommandes();
    }

    @GetMapping("/patient/{id}")
    @Override
    public CommandePatient findCommandePatientById(@PathVariable Long id) {
        return commandePatientService.findCommandeById(id);
    }
    @GetMapping("/patient/lignecommande/{id}")
    @Override
    public List<LigneCommandePatient> findAllLigneCommandePatient(@PathVariable Long id) {
        return commandePatientService.findAllLigneCommandePatient(id);
    }

    @PostMapping("/vendeur/save")
    @Override
    public CommandeVendeur saveCommandeVendeur(@RequestBody CommandeVendeur commandeVendeur) {
        return commandeVendeurService.saveCommande(commandeVendeur);
    }

    @GetMapping("/vendeur/all")
    @Override
    public List<CommandeVendeur> findAllCommandeVendeur() {
        return commandeVendeurService.findAllCommandes();
    }

    @GetMapping("/vendeur/{id}")
    @Override
    public CommandeVendeur findCommandeVendeurById(@PathVariable Long id) {
        return commandeVendeurService.findCommandeById(id);
    }

    @GetMapping("/vendeur/lignecommande/{id}")
    @Override
    public List<LigneCommandeVendeur> findAllLigneCommandeVendeur(@PathVariable Long id) {
        return commandeVendeurService.findAllLigneCommandeVendeur(id);
    }


}
