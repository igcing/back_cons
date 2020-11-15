package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FarmaciaDTO{
    private String fecha;
    private String local_id;
    private String local_nombre;
    private String comuna_nombre;
    private String localidad_nombre;
    private String local_direccion;
    private String funcionamiento_hora_apertura;
    private String funcionamiento_hora_cierre;
    private String local_telefono;
    private String local_lat;
    private String local_lng;
    private String funcionamiento_dia;
    private String fk_region;
    private String fk_comuna;
}