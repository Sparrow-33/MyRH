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

    private final OffreRepo offreRepo;

    @Override
    public Offre OffreByRecruiter(Long id) {
       return offreRepo.getOffreByRecruteurId(id) ;
    }

    @Override
    public Offre OffreById(Long id) {
        return offreRepo.getOffreById(id);
    }


    @Override
    public void DeleteById(Long id) {
        offreRepo.deleteById(id);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepo.findAll();
    }

    @Override
    public void updateOffre(Offre offre) {
        offreRepo.save(offre);
    }

    public boolean offreExists(Long id) {
      return  offreRepo.existsById(id);
    }

    public void addOffre( Offre offre) {
         offreRepo.save(offre);
    }

}
