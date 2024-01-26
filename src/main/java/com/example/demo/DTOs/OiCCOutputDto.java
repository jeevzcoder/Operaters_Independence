package com.example.demo.DTOs;

import com.example.demo.Models.Patent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Component
public class OiCCOutputDto {
    private String oIName;
    private Date dateOfLastCompletion;
    private Date startingDate;
    private Integer totalChanges;
    private List<Patent> newPatents;
    private List<Patent> statusChangePatents;
}
