package com.example.gestionpharmacie.web.ControllerImpl;


import com.example.gestionpharmacie.dao.entities.Vendeur;
import com.example.gestionpharmacie.metier.IVendeurService;
import com.example.gestionpharmacie.web.IVendeurRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/vendeur")
@CrossOrigin("*")
public class VendeurContoller implements IVendeurRestController {
    @Autowired
    private IVendeurService iVendeurService;
    @PostMapping("/")
    @Override
    public Vendeur save(@RequestBody Vendeur vendeur) {
        return iVendeurService.save(vendeur);
    }
    @GetMapping("/{id}")
    @Override
    public Vendeur getVendeurById(@PathVariable("id") Long id) {
        return iVendeurService.getVendeurById(id);
    }
    @GetMapping("/all")
    @Override
    public List<Vendeur> getAllVendeur() {
        return iVendeurService.getAllVendeur();
    }
    @PutMapping("/{id}")
    @Override
    public Vendeur updateVendeur(@RequestBody Vendeur vendeur,@PathVariable Long id) {
        return iVendeurService.updateVendeur(vendeur,id);
    }
}
