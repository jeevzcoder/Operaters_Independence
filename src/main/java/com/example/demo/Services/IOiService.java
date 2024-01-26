package com.example.demo.Services;

import com.example.demo.DTOs.OiCCOutputDto;
import com.example.demo.Models.Oi;
import com.example.demo.Models.Patent;

import java.util.List;

public interface IOiService {
    List<OiCCOutputDto> detectChanges(Long id) throws Exception;
     List<Patent> checkNewPatents(List<Patent> currentPat, List<Patent> pastPat) throws Exception;
}
