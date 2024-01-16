package com.example.gestionpharmacie.metier.ServiceImpl;

import com.example.gestionpharmacie.dao.entities.Vendeur;
import com.example.gestionpharmacie.dao.repositories.VendeurRepository;
import com.example.gestionpharmacie.metier.IVendeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendeurServiceImpl implements IVendeurService {
    @Autowired
    private VendeurRepository vendeurRepository;
    @Override
    public Vendeur save(Vendeur vendeur) {
        return vendeurRepository.save(vendeur);
    }

    @Override
    public Vendeur getVendeurById(Long id) {
        return vendeurRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Vendeur> getAllVendeur() {
        return vendeurRepository.findAll();
    }

    @Override
    public Vendeur updateVendeur(Vendeur vendeur, Long id) {
        Vendeur vendeur1 = vendeurRepository.findById(id).get();
        if(vendeur1.getIdVendeur()==null){
            throw new RuntimeException("vendeur n'existe pas");
        }
        vendeur.setIdVendeur(vendeur1.getIdVendeur());
        return vendeurRepository.save(vendeur);
    }
}
