package com.example.myrh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String email;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return id.equals(agent.id) && Objects.equals(nom, agent.nom) && email.equals(agent.email) && password.equals(agent.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, password);
    }
}
