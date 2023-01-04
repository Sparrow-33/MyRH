package com.example.myrh.repo;

import com.example.myrh.entities.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruteurRepo extends JpaRepository<Recruteur, Long> {

    Recruteur findByEmail(String email);
}
