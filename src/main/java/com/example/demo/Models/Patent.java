package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Patent extends BaseClass {
    @ManyToOne
    private Oi oi;
    private String patId;
    private String assignee;
    private String patentNumber;
    private String patentName;
    private String jurisdiction;
    private String applicationYear;
    private String legalStatus;
}
