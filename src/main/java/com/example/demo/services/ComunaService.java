package com.example.demo.services;

import com.example.demo.dto.ComunaDTO;
import org.springframework.http.ResponseEntity;

public interface ComunaService{
    public ResponseEntity<ComunaDTO[]> getComunas() throws Exception;
}
