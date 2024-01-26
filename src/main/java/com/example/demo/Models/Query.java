package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Query extends BaseClass {

    private String query;
    @OneToOne
    private Oi oi;
}
