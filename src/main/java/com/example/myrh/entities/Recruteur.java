package com.example.myrh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Recruteur {

    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = ID_GENERATOR.incrementAndGet();
    private String nom;
    private String email;
    private String password;
    private String telephone;

    @ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinTable(name = "recruteur_image",
                joinColumns = {
                   @JoinColumn(name = "recruteur_id")
                },
                inverseJoinColumns = {
                   @JoinColumn(name = "image_id")
                })
    private Set<Image> image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruteur recruteur = (Recruteur) o;
        return id.equals(recruteur.id) && nom.equals(recruteur.nom) && email.equals(recruteur.email) && password.equals(recruteur.password) && Objects.equals(telephone, recruteur.telephone) && Objects.equals(image, recruteur.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, password, telephone, image);
    }
}
