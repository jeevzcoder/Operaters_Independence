package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class SuperClass {

    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
