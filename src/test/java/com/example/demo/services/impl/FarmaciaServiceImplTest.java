package com.example.demo.services.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.dto.FarmaciaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class FarmaciaServiceImplTest {
    @Mock
    RestTemplate restTemplate = new RestTemplate();

    @InjectMocks
    @Spy
    FarmaciaServiceImpl farmaciaServiceImpl;

    @Test
    public void test() throws Exception {
/*
        String json =  "[{\"fecha\": \"12-11-2020\",\"local_id\": \"534\",\"local_nombre\": \"TORRES MPD\",\"comuna_nombre\": \"RECOLETA\",\"localidad_nombre\": \"RECOLETA\",\"local_direccion\": \"AVENIDA EL SALTO 2972\",\"funcionamiento_hora_apertura\": \"10:30 hrs.\",\"funcionamiento_hora_cierre\": \"19:30 hrs.\",\"local_telefono\": \"+560225053570\",\"local_lat\": \"-33.3996351\",\"local_lng\": \"-70.62894990000001\",\"funcionamiento_dia\": \"jueves\",\"fk_region\": \"7\",\"fk_comuna\": \"122\"}]" ;
        ObjectMapper objectMapper = new ObjectMapper();
        FarmaciaDTO[] arr = objectMapper.readValue(json, FarmaciaDTO[].class); 
        LstFarmaciaDTO lst = new LstFarmaciaDTO( List.of(arr) );
        ResponseEntity<FarmaciaDTO[]> responseArray = ResponseEntity.ok(arr);
        Mockito.when(restTemplate.getForEntity(
             "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7",
                                   FarmaciaDTO[].class) ).thenReturn(responseArray);
        ResponseEntity responseLst = ResponseEntity.ok(lst);
        Mockito.when(farmaciaServiceImpl.getFarmacias(anyString())).thenReturn(responseLst);

        ResponseEntity<FarmaciaDTO[]> realValue = farmaciaServiceImpl.getFarmacias("");
        
        Assert.assertEquals(realValue, responseLst);
*/

    }
}
