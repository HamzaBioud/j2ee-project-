package com.example.gestionpharmacie;

import com.example.gestionpharmacie.dao.entities.*;
import com.example.gestionpharmacie.dao.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@Transactional
public class GestionPharmacieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPharmacieApplication.class, args);
	}

	@Bean
	CommandLineRunner vendeur(VendeurRepository vendeurRepository) {
		return args -> {
			Stream.of("vendeur1", "vendeur2", "vendeur3", "vendeur4").forEach(name -> {
				Vendeur vendeur = new Vendeur("Mr", name, "+212600550025", name.toLowerCase() + "@domain.com");
				vendeurRepository.save(vendeur);
			});
			vendeurRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	CommandLineRunner patient(PatientRepository patientRepository) {
		return args -> {
			Stream.of("patient1", "patient2", "patient3", "patient4", "patient5").forEach(name -> {
				Patient patient = new Patient("Mr", name, "+212600550025", name.toLowerCase() + "4785");
				patientRepository.save(patient);
			});
			patientRepository.findAll().forEach(System.out::println);
		};
	}
	@Bean
	CommandLineRunner medicament(MedicamentRepository medicamentRepository) {
		return args -> {
			Stream.of("DOLIPRANE", "EFFERALGAN", "DAFALGAN", "IMODIUM", "LEVOTHYROX").forEach(name -> {
				Medicament medicament = new Medicament(name,"12"+name, BigDecimal.valueOf(47));
				medicamentRepository.save(medicament);
			});
			medicamentRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	CommandLineRunner commandePatient(CommandePatientRepository commandePatientRepository,
									  PatientRepository patientRepository,
									  MedicamentRepository medicamentRepository,
									  LigneCommandePatientRepository ligneCommandePatientRepository){
		return args -> {
			Patient patient = patientRepository.findById(Long.valueOf(1)).get();
			Patient patient1 = patientRepository.findById(Long.valueOf(2)).get();
			List<Medicament> medicamentList = medicamentRepository.findAll();
			Medicament medicament1 = medicamentRepository.findById(Long.valueOf(1)).get();
			List<LigneCommandePatient> ligneCommandePatients = new ArrayList<>();
			List<LigneCommandePatient> ligneCommandePatients1 = new ArrayList<>();
			CommandePatient commandePatient = CommandePatient.builder()
					.code("commande-01")
					.etatCommande(EtatCommande.EN_PREPARATION)
					.dateCommande(LocalDate.now())
					.patient(patient)
					.build();
			CommandePatient commandePatient1 = CommandePatient.builder()
					.code("commande-02")
					.etatCommande(EtatCommande.VALIDEE)
					.dateCommande(LocalDate.now())
					.patient(patient1)
					.build();
			commandePatientRepository.save(commandePatient);
			commandePatientRepository.save(commandePatient1);
			for (Medicament medicament: medicamentList) {
					LigneCommandePatient ligneCommandePatient = LigneCommandePatient.builder()
							.quantite(BigDecimal.valueOf(2))
							.commandePatient(commandePatient)
							.medicament(medicament)
							.prixUnitaire(medicament.getPrix().multiply(BigDecimal.valueOf(2)))
							.build();
					ligneCommandePatients.add(ligneCommandePatient);
					ligneCommandePatientRepository.save(ligneCommandePatient);

			}
			LigneCommandePatient ligneCommandePatient1 = LigneCommandePatient.builder()
							.quantite(BigDecimal.valueOf(3))
									.commandePatient(commandePatient1)
											.medicament(medicament1)
													.prixUnitaire(medicament1.getPrix())
															.build();
			ligneCommandePatientRepository.save(ligneCommandePatient1);
			ligneCommandePatients1.add(ligneCommandePatient1);

			commandePatient.setLigneCommandePatients(ligneCommandePatients);
			commandePatient1.setLigneCommandePatients(ligneCommandePatients1);
			commandePatientRepository.save(commandePatient);
			commandePatientRepository.save(commandePatient1);
			commandePatientRepository.findAll().forEach(System.out::println);

		};
	}
    @Bean
    CommandLineRunner commandeVendeur(CommandeVendeurRepository commandeVendeurRepository,
                                      VendeurRepository vendeurRepository,
                                      MedicamentRepository medicamentRepository,
                                      LigneCommandeVendeurRepository ligneCommandeVendeurRepository){
        return args -> {
			Vendeur vendeur = vendeurRepository.findById(Long.valueOf(1)).get();
			List<Medicament> medicamentList = medicamentRepository.findAll();
			List<LigneCommandeVendeur> ligneCommandeVendeurs = new ArrayList<>();
			CommandeVendeur commandeVendeur = CommandeVendeur.builder()
					.code("commande-vendeur-01")
					.dateCommande(LocalDate.now())
					.etatCommande(EtatCommande.EN_PREPARATION)
					.vendeur(vendeur)
					.build();
			commandeVendeurRepository.save(commandeVendeur);
			for(Medicament medicament:medicamentList){
				LigneCommandeVendeur ligneCommandeVendeur = LigneCommandeVendeur.builder()
						.medicament(medicament)
						.quantite(BigDecimal.ONE)
						.prixUnitaire(BigDecimal.valueOf(14))
						.commandeVendeur(commandeVendeur)
						.build();
				ligneCommandeVendeurs.add(ligneCommandeVendeur);
				ligneCommandeVendeurRepository.save(ligneCommandeVendeur);
			}
			commandeVendeur.setLigneCommandeVendeurs(ligneCommandeVendeurs);
			commandeVendeurRepository.save(commandeVendeur);
			commandeVendeurRepository.findAll().forEach(System.out::println);
        };
    }
}
