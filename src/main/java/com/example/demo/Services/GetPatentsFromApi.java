package com.example.demo.Services;

import com.example.demo.DTOs.ApiPatentsDto;
import com.example.demo.DTOs.ApiResponseDto;
import com.example.demo.Models.Patent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
@Slf4j
public class GetPatentsFromApi {

    //logger.info("Adding this"+pat);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;//="https://global-patent1.p.rapidapi.com/s?ds=us&q=AI";

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.host}")
    private String apiHost ;

    private List<Patent> convertDtoPatentsToPatents(ApiResponseDto responseDto){
        List<ApiPatentsDto> resposePatents=responseDto.getPatents();
        List<Patent> patents=new ArrayList<>();
        for(ApiPatentsDto pat:resposePatents){
            Patent p=new Patent();
            p.setPatentName(pat.getTitle());
            p.setPatId(pat.getId());
            p.setPatentNumber(pat.getDocumentNumber());
            p.setAssignee(pat.getCurrentAssignee());
            p.setApplicationYear(pat.getApplicationDate());
            p.setLegalStatus(pat.getLegalStatus());
            patents.add(p);
        }
        log.info("calling fot Dto to patentg conversion");
        return patents;
    }

    public List<Patent> callAPIAndGetResponse(String query) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey );
        headers.set("X-RapidAPI-Host", apiHost);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        // Make the GET request with the HttpEntity containing headers
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                String.class
        );
        String jsonString = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseDto responseDto = objectMapper.readValue(jsonString, ApiResponseDto.class);
        List<ApiPatentsDto> patents=responseDto.getPatents();
        log.info("calling CallAPi and Get response method");

        return convertDtoPatentsToPatents(responseDto);
    }




}

