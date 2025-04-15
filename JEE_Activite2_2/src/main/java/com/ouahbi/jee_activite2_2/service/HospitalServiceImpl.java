package com.ouahbi.jee_activite2_2.service;

import com.ouahbi.jee_activite2_2.entities.Consultation;
import com.ouahbi.jee_activite2_2.entities.Medecin;
import com.ouahbi.jee_activite2_2.entities.Patient;
import com.ouahbi.jee_activite2_2.entities.RendezVous;
import com.ouahbi.jee_activite2_2.repositories.ConsultationRepository;
import com.ouahbi.jee_activite2_2.repositories.MedecinRepository;
import com.ouahbi.jee_activite2_2.repositories.PatientRepository;
import com.ouahbi.jee_activite2_2.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,MedecinRepository medecinRepository,ConsultationRepository consultationRepository,RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findByIdP(Long id) {
        return patientRepository.findById(1L).get();
    }

    @Override
    public RendezVous findByIdR(Long id) {
        return rendezVousRepository.findAll().get(0);
    }

    @Override
    public Patient findByNomP(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin findByNomM(String nom) {
        return medecinRepository.findByNom(nom);
    }
}
