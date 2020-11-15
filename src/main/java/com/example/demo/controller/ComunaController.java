package com.example.demo.controller;

import com.example.demo.dto.ComunaDTO;
import com.example.demo.services.ComunaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para obtener las comunas
 */
@RestController
@RequestMapping("/search/comuna")
@Slf4j
@CrossOrigin(origins = "*")
public class ComunaController {

    @Autowired
    ComunaService comunaService;

    /**
     * Método para obtener comunas
     * @return ResponseEntity<ComunaDTO[]>
     */
    @GetMapping()
    public ResponseEntity<ComunaDTO[]> getComunas() throws Exception{
        return comunaService.getComunas();
    }
}