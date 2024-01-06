package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class AssetTeam extends SuperClass {
    @OneToOne
    private FTO fto;
    private String name;
    private String emailId;
}
