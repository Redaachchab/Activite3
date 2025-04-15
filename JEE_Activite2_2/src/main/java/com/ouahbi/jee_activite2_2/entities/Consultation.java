package com.ouahbi.jee_activite2_2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateConsultation;
    private String rapport;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private RendezVous rendezVous;
}
