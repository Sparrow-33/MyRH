package com.example.myrh.repo;

import com.example.myrh.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepo extends JpaRepository<Agent, Long> {
}
