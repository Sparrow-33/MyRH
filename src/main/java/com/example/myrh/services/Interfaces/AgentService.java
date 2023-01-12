package com.example.myrh.services.Interfaces;

import com.example.myrh.entities.Agent;
import com.example.myrh.exceptions.NoSuchUserException;

public interface AgentService {

    Agent findAgentByEmail(String email) throws NoSuchUserException;
}
