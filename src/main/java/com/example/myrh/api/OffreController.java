package com.example.myrh.api;

import com.example.myrh.entities.Image;
import com.example.myrh.entities.Offre;
import com.example.myrh.entities.Recruteur;
import com.example.myrh.services.Implementation.OffreServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor

@RequestMapping("/offre")
public class OffreController {

  private final OffreServiceImplementation offre;
  @GetMapping("/getAll")
    public ResponseEntity<List<Offre>> getAllOffre() {
    List<Offre> list = offre.getAllOffres();
      return ResponseEntity.ok(list );
  }




  }


























