package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Oi extends BaseClass {
    private String Name;
    /*@OneToOne
    private Query query;
    @OneToMany
    private List<AssetTeam> aTeam;
    @OneToMany
    private List<Searcher> searchers;
    @OneToMany
    private List<Patent> patents;*/




}
