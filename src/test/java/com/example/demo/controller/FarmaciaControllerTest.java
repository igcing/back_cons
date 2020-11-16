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

   
}
