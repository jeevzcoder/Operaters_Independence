package com.example.demo.Services;

import com.example.demo.DTOs.FtoCCOutputDto;
import com.example.demo.Models.Patent;

import java.util.List;

public interface IFtoService {
    public List<Patent> detectChanges(Long id) throws Exception;
}
