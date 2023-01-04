package com.example.myrh.repo;

import com.example.myrh.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepo extends JpaRepository<Candidat, Long> {
}
