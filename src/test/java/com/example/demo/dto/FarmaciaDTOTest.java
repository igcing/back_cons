package com.example.demo.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FarmaciaDTOTest {
    @Test
    public void test(){
        String res = "X";
        FarmaciaDTO farm = new FarmaciaDTO();
        farm.setComuna_nombre(res);
        farm.setFk_comuna(res);
        farm.setFecha(res);
        farm.setFk_region(res);
        farm.setFuncionamiento_dia(res);
        farm.setLocal_id(res);
        farm.setLocal_direccion(res);
        farm.setLocal_lat(res);
        farm.setLocal_lng(res);
        farm.setLocal_nombre(res);
        farm.setLocal_telefono(res);
        farm.setLocalidad_nombre(res);
        farm.setFuncionamiento_dia(res);
        farm.setFuncionamiento_hora_cierre(res);
        farm.setFuncionamiento_hora_apertura(res);

        Assert.assertNotNull(farm.getFecha());
        Assert.assertNotNull(farm.getComuna_nombre());
        Assert.assertNotNull(farm.getFk_comuna());
        Assert.assertNotNull(farm.getLocal_nombre());
        Assert.assertNotNull(farm.getFuncionamiento_dia());
        Assert.assertNotNull(farm.getLocal_id());
        Assert.assertNotNull(farm.getLocalidad_nombre());
        Assert.assertNotNull(farm.getLocal_telefono());
        Assert.assertNotNull(farm.getLocal_direccion());
        Assert.assertNotNull(farm.getFk_region());
        Assert.assertNotNull(farm.getFuncionamiento_hora_apertura());
        Assert.assertNotNull(farm.getFuncionamiento_hora_cierre());
    }
}
