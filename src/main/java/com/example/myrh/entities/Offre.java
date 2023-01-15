package com.example.myrh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recruteur_id", referencedColumnName = "id")
    private Recruteur recruteur;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private String profile;
    private String niveau;
    private String ville;
    private String salaire;
    private  int candidature;
    private boolean status;
    private LocalDate created_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offre offre = (Offre) o;
        return candidature == offre.candidature && status == offre.status && id.equals(offre.id) && recruteur.equals(offre.recruteur) && Objects.equals(title, offre.title) && Objects.equals(description, offre.description) && Objects.equals(profile, offre.profile) && Objects.equals(niveau, offre.niveau) && Objects.equals(ville, offre.ville) && Objects.equals(salaire, offre.salaire) && Objects.equals(created_at, offre.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recruteur, title, description, profile, niveau, ville, salaire, candidature, status, created_at);
    }
}
