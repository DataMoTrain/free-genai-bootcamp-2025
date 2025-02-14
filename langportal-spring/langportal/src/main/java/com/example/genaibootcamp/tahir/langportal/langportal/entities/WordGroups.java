package com.example.genaibootcamp.tahir.langportal.langportal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "word_groups")
public class WordGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false)
    private Words word;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Groups group;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Words getWord() {
        return word;
    }

    public void setWord(Words word) {
        this.word = word;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}
