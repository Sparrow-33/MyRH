package com.example.myrh.services.Interfaces;

import com.example.myrh.entities.Offre;

import java.util.List;

public interface OffreService {

    Offre OffreByRecruiter(Long id);

    Offre OffreById(Long id);

    void DeleteById(Long id);

    List<Offre> getAllOffres();

    void updateOffre(Offre offre);

}
