package com.example.genaibootcamp.tahir.langportal.langportal.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "words")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "japanese", nullable = false)
    private String japanese;

    @Column(name = "romaji", nullable = false)
    private String romaji;

    @Column(name = "english", nullable = false)
    private String english;

    @Column(name = "parts", columnDefinition = "json")
    private String parts;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }
}
