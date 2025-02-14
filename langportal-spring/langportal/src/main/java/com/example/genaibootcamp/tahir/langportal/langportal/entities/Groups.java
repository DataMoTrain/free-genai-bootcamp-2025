package com.example.genaibootcamp.tahir.langportal.langportal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

     // Default constructor
     public Groups() {}

     // Constructor with name parameter
     public Groups(String name) {
         this.name = name;
     }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}