package com.example.genaibootcamp.tahir.langportal.langportal.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "study_activities")
public class StudyActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "preview_url")
    private String previewUrl;

    // Default constructor
    public StudyActivities() {}

    // Constructor with parameters
    public StudyActivities(String name, String url, String previewUrl) {
        this.name = name;
        this.url = url;
        this.previewUrl = previewUrl;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}
