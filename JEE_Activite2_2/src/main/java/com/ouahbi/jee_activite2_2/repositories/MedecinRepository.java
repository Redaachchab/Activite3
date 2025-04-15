package com.ouahbi.jee_activite2_2.repositories;

import com.ouahbi.jee_activite2_2.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);

}
