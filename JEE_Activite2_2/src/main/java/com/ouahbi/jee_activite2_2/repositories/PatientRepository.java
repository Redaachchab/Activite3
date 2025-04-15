package com.ouahbi.jee_activite2_2.repositories;

import com.ouahbi.jee_activite2_2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
