package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Searcher extends SuperClass{
    private String name;
    private String emailId;
    @OneToOne
    private FTO fto;
}
