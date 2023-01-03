package com.example.myrh.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;
    private String password;
    private String resume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return id.equals(candidat.id) && Objects.equals(nom, candidat.nom) && email.equals(candidat.email) && password.equals(candidat.password) && Objects.equals(resume, candidat.resume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, password, resume);
    }

}
