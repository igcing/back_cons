package com.example.demo.services;

import com.example.demo.dto.ComunaDTO;
import org.springframework.http.ResponseEntity;


/**
 * Interfaz para registrar los métodos de service comuna
 */
public interface ComunaService{
    public ResponseEntity<ComunaDTO[]> getComunas() throws Exception;
}
