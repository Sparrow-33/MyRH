package com.example.myrh.services.Implementation;

import com.example.myrh.entities.Agent;
import com.example.myrh.exceptions.NoSuchUserException;
import com.example.myrh.repo.AgentRepo;
import com.example.myrh.services.Interfaces.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Service
public class AgentServiceImplementation implements AgentService {

    private final AgentRepo agentRepo;

    @Override
    public Agent findAgentByEmail(String email) throws NoSuchUserException {
        Agent agent = agentRepo.findAgentByEmail(email);
        if (agent == null) {
            throw new NoSuchUserException();
        }
        return agent;
    }
}
