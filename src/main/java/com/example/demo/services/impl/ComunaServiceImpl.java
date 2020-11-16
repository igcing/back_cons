package com.example.demo.services.impl;

import com.example.demo.config.Config;
import com.example.demo.constants.Constants;
import com.example.demo.dto.ComunaDTO;
import com.example.demo.services.ComunaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

/**
 * Implementación de interfaz para comuna
 */
@Slf4j
@Service
public class ComunaServiceImpl implements ComunaService{
    RestTemplate restTemplate;
    Config config;
    
    @Autowired
    public ComunaServiceImpl(RestTemplate restTemplate, Config config){
        this.restTemplate = restTemplate;
        this.config = config;
    }

    /**
     * Método para obtener comunas
     * @return ResponseEntity<ComunaDTO[]>
     */
    public ResponseEntity<ComunaDTO[]> getComunas() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add(Constants.TAG_REGION, Constants.ID_REGION);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( config.getComuna(), request , String.class );
        String responseComunas = response.getBody();
        ComunaDTO[] arr = getCleanComunas(responseComunas);
        return ResponseEntity.ok(arr);
    }

    /**
     * Método limpia xml de comunas para object ComunaDTO[]
     * @param responseComunas
     * @return ComunaDTO[]
     */
    public ComunaDTO[] getCleanComunas(String responseComunas){
        return Arrays.stream(responseComunas.split(Constants.TAG_OPEN_OPTION)).map(x -> {
            String opt = x;
            String id = opt.replaceAll(Constants.EXPREG_CLEAN_ID,"").replaceAll(Constants.TAG_OPEN_OPTION+" ","");
            String value=opt.replaceAll(Constants.EXPREG_CLEAN_VALUE,"")
                    .replaceAll(Constants.TAG_CLOSE_OPTION,"")
                    .replaceAll(id,"")
                    .replaceAll(Constants.EXPREG_CLEAN_SELECT,"");
            id = id.replaceAll(Constants.EXPREG_CLEAN_VALEU_EQUAL,"").replaceAll("\'","");

        return new ComunaDTO(id, value);
        }).toArray(ComunaDTO[]::new);
    }

}