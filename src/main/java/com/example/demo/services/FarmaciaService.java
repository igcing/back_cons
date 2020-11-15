package com.example.demo.services;

import com.example.demo.dto.FarmaciaDTO;
import org.springframework.http.ResponseEntity;

public interface FarmaciaService{
    public ResponseEntity<FarmaciaDTO[]> getFarmacias(String idRegion) throws Exception;
    public ResponseEntity<FarmaciaDTO[]> getFarmacia(String idRegion, String idComuna, String nombreLocal) throws Exception;

}