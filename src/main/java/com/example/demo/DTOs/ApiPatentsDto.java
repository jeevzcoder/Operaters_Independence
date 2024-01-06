package com.example.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


@Getter
@Setter
//@Component
//import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiPatentsDto {
    private String id;
    private String rank;
    private String legalStatus;
    private String type;
    private String title;
    private String summary;
    private String applicant;
    private String applicationDate;
    private String applicantAddress;
    private String mainIpc;
    private String applicationNumber;
    private String documentNumber;
    private String documentDate;
    private String inventor;
    private String currentAssignee;
    private String currentAssigneeAddress;
    private String ipc;
    private String province;
    private String city;
    private String imagePath;
}
