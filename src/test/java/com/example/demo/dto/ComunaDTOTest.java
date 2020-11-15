package com.example.demo.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComunaDTOTest {
    @Test
    public void test(){
        ComunaDTO comuna = new ComunaDTO("","");
        comuna.setValue("");
        comuna.setId("");
        Assert.assertNotNull(comuna.getId());
        Assert.assertNotNull(comuna.getValue());
    }
}
