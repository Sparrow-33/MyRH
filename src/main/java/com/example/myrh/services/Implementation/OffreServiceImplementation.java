package com.example.myrh.services.Implementation;

import com.example.myrh.entities.Offre;
import com.example.myrh.repo.OffreRepo;
import com.example.myrh.services.Interfaces.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OffreServiceImplementation implements OffreService {

    private final OffreRepo offre;

    @Override
    public Offre OffreByRecruiter(Long id) {
       return offre.getOffreByRecruteurId(id) ;
    }

    @Override
    public Offre OffreById(Long id) {
        return offre.getOffreById(id);
    }


    @Override
    public void DeleteById(Long id) {
        offre.deleteById(id);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offre.findAll();
    }
}
