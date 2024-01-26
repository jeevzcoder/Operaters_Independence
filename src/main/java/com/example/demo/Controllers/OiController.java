package com.example.demo.Controllers;

import com.example.demo.DTOs.OiCCOutputDto;
import com.example.demo.Models.Oi;
import com.example.demo.Models.Patent;
import com.example.demo.Services.OiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/oi")
public class OiController {
    OiService oiService;
    RestTemplate restTemplate;

    @Autowired
    public OiController(OiService oiService){
        this.oiService = oiService;
    }

    @GetMapping("/{inputDto}")
    public ResponseEntity<List<OiCCOutputDto>> detectChanges(@PathVariable("inputDto") Long inputDto) throws Exception{
        
        ResponseEntity<List<OiCCOutputDto>> response=new ResponseEntity<>(oiService.detectChanges(inputDto), HttpStatus.OK);
        return response;
        


    }
}
