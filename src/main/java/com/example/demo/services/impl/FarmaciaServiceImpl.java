package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.config.Config;
import com.example.demo.dto.FarmaciaDTO;
import com.example.demo.predicates.FilterPredicate;
import com.example.demo.services.FarmaciaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FarmaciaServiceImpl implements FarmaciaService {
   RestTemplate restTemplate;
   Config config;

   @Autowired
   public FarmaciaServiceImpl(RestTemplate restTemplate ,  Config config){
      this.restTemplate = restTemplate;
      this.config = config;
   }

   public ResponseEntity<FarmaciaDTO[]> getFarmacias(String idRegion) throws Exception {
      String url = config.getFarmacia();
      log.info("url: {}" , url);
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      FarmaciaDTO[] arr = objectMapper.readValue(response.getBody(), FarmaciaDTO[].class);
      return ResponseEntity.ok(arr);

   }

   @Override
   public ResponseEntity<FarmaciaDTO[]> getFarmacia(String idRegion, String idComuna, String nombreLocal)
         throws Exception {
      ResponseEntity<FarmaciaDTO[]> response = this.getFarmacias(idRegion);
      log.info("idComuna => {} - nombreLocal: {}" , idComuna, nombreLocal);
      /*Predicate<FarmaciaDTO> equalComuna = x -> idComuna.equals(x.getFk_comuna());
      Predicate<FarmaciaDTO> containsNombreLocal = x -> nombreLocal.contains(x.getLocal_nombre()) ;
      Predicate<FarmaciaDTO> finalFilter = equalComuna.or(containsNombreLocal);*/


      Stream<FarmaciaDTO> stream = Arrays.stream(response.getBody());
      FarmaciaDTO[] filtered =  stream.parallel().filter(x ->
              FilterPredicate.isSatisfyFilter(idComuna,nombreLocal).test(x)
         )
         .toArray(FarmaciaDTO[]::new);

      return ResponseEntity.ok(filtered);
   }
/*
   Request =>  Comuna (Cerrillos, Macul, etc), Nombre del local (Ahumada, Cruz Verde, etc.)
   Response =>  Nombre de local, Dirección, Teléfono, Latitud, Longitud.
*/
}
