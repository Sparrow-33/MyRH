package com.example.myrh.services.Interfaces;

import com.example.myrh.entities.Recruteur;
import com.example.myrh.exceptions.NoSuchUserException;

public interface RecruteurService {

    Recruteur findRecruteurByEmail( String email) throws NoSuchUserException;

}
