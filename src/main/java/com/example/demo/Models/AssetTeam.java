package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class AssetTeam extends BaseClass {
    private String name;
    private String emailId;
    @ManyToOne
    private Oi oi;
}
