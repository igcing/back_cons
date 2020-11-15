package com.example.demo.controller;

import com.example.demo.services.ComunaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ComunaControllerTest {

    @InjectMocks
    ComunaController comunaController;

    @Mock
    ComunaService comunaService;

    @Test
    public void test() throws Exception {
       /* ResponseEntity<String> response = ResponseEntity.ok("");
        ResponseEntity<String> responseR;
        Mockito.when(comunaService.getComunas()).thenReturn(response);

        responseR = comunaController.getComunas();

        Assert.assertEquals(responseR, response);*/

    }
}
