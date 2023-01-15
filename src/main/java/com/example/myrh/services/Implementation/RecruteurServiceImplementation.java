package com.example.myrh.services.Implementation;

import com.example.myrh.entities.Recruteur;
import com.example.myrh.exceptions.NoSuchUserException;
import com.example.myrh.repo.RecruteurRepo;
import com.example.myrh.services.Interfaces.RecruteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecruteurServiceImplementation implements RecruteurService {

    private final RecruteurRepo repo;
    @Override
    public Recruteur findRecruteurByEmail( String email) throws NoSuchUserException {
        Recruteur recruteur = repo.findByEmail(email);
        if( recruteur == null) {
            throw new NoSuchUserException();
        }
        return recruteur;
    }

    @Override
    public void recruteurRegister(Recruteur recruteur) {
        repo.save(recruteur);
    }


}
