package com.example.genaibootcamp.tahir.langportal.langportal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyActivityDTO {

    private String name;
    private String url;
    
    @JsonProperty("preview_url")
    private String previewUrl;

    // Default constructor
    public StudyActivityDTO() {}

    // Constructor with parameters
    public StudyActivityDTO(String name, String url, String previewUrl) {
        this.name = name;
        this.url = url;
        this.previewUrl = previewUrl;
    }

    // Getters and Setters
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