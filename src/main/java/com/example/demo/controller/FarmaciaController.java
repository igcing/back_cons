package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.server.PathParam;

import com.example.demo.dto.FarmaciaDTO;
import com.example.demo.services.FarmaciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/search/farmacia/")
@Slf4j
@CrossOrigin(origins = "*")
public class FarmaciaController {

    @Autowired
    FarmaciaService farmaciaService;

    @GetMapping("/{idRegion}")
    public ResponseEntity<FarmaciaDTO[]> getFarmacias(@PathVariable("idRegion") String idRegion){
        try{
            return farmaciaService.getFarmacias(idRegion);
        }catch(Exception e){
            log.error("Error" , e);
        }
        return new ResponseEntity<FarmaciaDTO[]>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{idRegion}/filter")
    public ResponseEntity<FarmaciaDTO[]> getFarmacia(@PathParam("idRegion") String idRegion,
    @RequestParam(value="idComuna" , required = false) String idComuna, @RequestParam(value="nombreLocal" , required = false) String nombreLocal){
        try{
            return farmaciaService.getFarmacia(idRegion, idComuna, nombreLocal);
        }catch(Exception e){
            log.error("Error" , e);
        }
        return new ResponseEntity<FarmaciaDTO[]>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //Nombre de local, Dirección, Teléfono, Latitud, Longitud.
}