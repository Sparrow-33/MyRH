package com.example.myrh.repo;

import com.example.myrh.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OffreRepo extends JpaRepository<Offre, Long> {

    Offre getOffreByRecruteurId(Long recruteur_id);
    Offre getOffreByCreated_at(LocalDate date);

    Offre getOffreById(Long id);

    void deleteById(Long id);

    List<Offre> findAll();
}
