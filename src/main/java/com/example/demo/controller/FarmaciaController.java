package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.server.PathParam;

import com.example.demo.constants.Constants;
import com.example.demo.dto.FarmaciaDTO;
import com.example.demo.services.FarmaciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Controlador para realizar búsqueda de farmacias
 */
@RestController
@RequestMapping(Constants.ENDPOINT_FARMACIA_CONTROLLER)
@Slf4j
@CrossOrigin(origins = "*")
public class FarmaciaController {

    @Autowired
    FarmaciaService farmaciaService;

    /**
     * Método obtiene farmacias por region, idComuna y nombre de local
     * @param idRegion
     * @param idComuna
     * @param nombreLocal
     * 
     * @return ResponseEntity<FarmaciaDTO[]>
     */
    @GetMapping(Constants.ENDPOINT_FARMACIA_FILTER)
    public ResponseEntity<FarmaciaDTO[]> getFarmacia(@PathParam("idRegion") String idRegion,
    @RequestParam(value="idComuna" , required = false) String idComuna, @RequestParam(value="nombreLocal" , required = false) String nombreLocal){
        try{
            return farmaciaService.getFarmacia(idRegion, idComuna, nombreLocal);
        }catch(Exception e){
            log.error("Error" , e);
        }
        return new ResponseEntity<FarmaciaDTO[]>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}