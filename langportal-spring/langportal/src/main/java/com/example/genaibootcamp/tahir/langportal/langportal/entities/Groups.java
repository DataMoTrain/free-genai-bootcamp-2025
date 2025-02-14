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

    @Column(name = "words_count", nullable = false)
    private Integer wordsCount;


     // Default constructor
     public Groups() {}

     // Constructor with name parameter
     public Groups(String name, Integer wordsCount) {
         this.name = name;
         this.wordsCount = wordsCount;
     }

     public Groups(String name) {
        this.name = name;
        this.wordsCount = 0;
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