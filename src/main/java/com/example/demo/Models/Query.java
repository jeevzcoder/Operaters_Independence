package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Query extends SuperClass{
    private String query;
    @OneToOne
    private FTO fto;
}
