package com.example.demo.services.impl;

import com.example.demo.config.Config;
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

    public ResponseEntity<ComunaDTO[]> getComunas() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("reg_id", "7");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( config.getComuna(), request , String.class );
        //first part: (value='(.*?)')?
        // second part :>(.*?)<\/option>
        String r = response.getBody();
        ComunaDTO[] arr = Arrays.stream(r.split("<option")).map(x -> {
            String opt = x;
            String id = opt.replaceAll("( {0,1}(selected){0,1}>(.*?)<\\/option>)","").replaceAll("<option ","");
            String value=opt.replaceAll("(<option value='(.*?)'( selected){0,}>)?","")
                    .replaceAll("</option>","")
                    .replaceAll(id,"")
                    .replaceAll("( selected>){0,1}>{0,1}","");
            id = id.replaceAll("value=","").replaceAll("\'","");

        return new ComunaDTO(id, value);
        }).toArray(ComunaDTO[]::new);
        return ResponseEntity.ok(arr);
    }

}