package com.example.demo.Controllers;

import com.example.demo.Models.Patent;
import com.example.demo.Services.FtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/Fto")
public class FtoController {

    //IFtoService ftoService;
    FtoService ftoService;
    RestTemplate restTemplate;

    @Autowired
    public FtoController(FtoService ftoService){
        this.ftoService=ftoService;
    }

    @GetMapping("/{inputDto}")
    public List<Patent> detectChanges(@PathVariable("inputDto") Long inputDto) throws Exception{
        return ftoService.detectChanges(inputDto);
        //FtoCCOutputDto outputDto =new FtoCCOutputDto();
        //outputDto.setNewPatents(pat);
        //System.out.println(pat);
        //return outputDto;
    }
}
