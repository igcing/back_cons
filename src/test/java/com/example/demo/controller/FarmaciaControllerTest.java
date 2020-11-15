package com.example.demo.controller;

import com.example.demo.dto.FarmaciaDTO;
import com.example.demo.services.FarmaciaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class FarmaciaControllerTest {

    @InjectMocks
    FarmaciaController farmaciaController;

    @Mock
    FarmaciaService farmaciaService;

    @Test
    public void test_getFarmacia() throws Exception {
        List<FarmaciaDTO> lstFarm = List.of(new FarmaciaDTO());

        ResponseEntity<FarmaciaDTO[]> response = ResponseEntity.ok(
                lstFarm.toArray(FarmaciaDTO[]::new));
        ResponseEntity<FarmaciaDTO[]> responseR;
        Mockito.when(farmaciaService.getFarmacia(anyString(),anyString(),anyString()))
                .thenReturn(response);

        responseR = farmaciaService.getFarmacia("","","");


        Assert.assertEquals(responseR, farmaciaController.getFarmacia("","",""));

    }

    @Test
    public void test_getFarmacias() throws Exception {
        List<FarmaciaDTO> lstFarm = List.of(new FarmaciaDTO());
        ResponseEntity<FarmaciaDTO[]> responseR;
        ResponseEntity<FarmaciaDTO[]> response = ResponseEntity.ok(
                lstFarm.toArray(FarmaciaDTO[]::new));

        Mockito.when(farmaciaService.getFarmacias(anyString()))
                .thenReturn(response);

        responseR = farmaciaService.getFarmacias("");

        Assert.assertEquals(responseR, farmaciaController.getFarmacias(""));
    }
}
