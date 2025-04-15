package com.ouahbi.jee_activite2_2;

import com.ouahbi.jee_activite2_2.entities.*;
import com.ouahbi.jee_activite2_2.repositories.ConsultationRepository;
import com.ouahbi.jee_activite2_2.repositories.MedecinRepository;
import com.ouahbi.jee_activite2_2.repositories.PatientRepository;
import com.ouahbi.jee_activite2_2.repositories.RendezVousRepository;
import com.ouahbi.jee_activite2_2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JeeActivite22Application {

    public static void main(String[] args) {
        SpringApplication.run(JeeActivite22Application.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService) {
        return args -> {
            Stream.of("Med","Ali","hanane")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Omar","Sanae","aymane")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"CARDIO":"DENTISTE");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = hospitalService.findByIdP(1L);
            Patient patient1 = hospitalService.findByNomP("Med");
            Medecin medecin = hospitalService.findByNomM("Omar");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = hospitalService.findByIdR(1L);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("aaaaaa");
            hospitalService.saveConsultation(consultation);
        };
    }
}
