package com.ouahbi.jee_activite2_2.service;

import com.ouahbi.jee_activite2_2.entities.Consultation;
import com.ouahbi.jee_activite2_2.entities.Medecin;
import com.ouahbi.jee_activite2_2.entities.Patient;
import com.ouahbi.jee_activite2_2.entities.RendezVous;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    public Medecin saveMedecin(Medecin medecin);
    public RendezVous saveRDV(RendezVous rendezVous);
    public Consultation saveConsultation(Consultation consultation);
    public Patient findByIdP(Long id);
    public RendezVous findByIdR(Long id);
    public Patient findByNomP(String nom);
    public Medecin findByNomM(String nom);
}
