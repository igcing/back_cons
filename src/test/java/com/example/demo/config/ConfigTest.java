package com.example.demo.config;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


public class ConfigTest {
    @Test
    public void test(){
        Config config = new Config();
        config.setFarmacia("");

        Assert.assertNotNull(config.getFarmacia());
        config.setComuna("");

        Assert.assertNotNull(config.getComuna());


    }
}
/*String value = "A";
        Config config = mock(Config.class);
        doNothing().when(config).setFarmacia(anyString());
        config.setFarmacia(value);
        verify(config, times(1)).setFarmacia(anyString());

        Mockito.when(config.getFarmacia()).thenReturn(value);

        Assert.assertEquals(value, config.getFarmacia());*/