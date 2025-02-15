package com.example.genaibootcamp.tahir.langportal.langportal.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecentSessionDTO {

    private Integer id;
    @JsonProperty("group_id")
    private Integer groupId;

    @JsonProperty("activity_name")
    private String activityName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("correct_count")
    private Long correctCount;

    @JsonProperty("wrong_count")
    private Long wrongCount;

    public RecentSessionDTO(Integer id, Integer groupId, String activityName, LocalDateTime createdAt, Long correctCount, Long wrongCount) {
        this.id = id;
        this.groupId = groupId;
        this.activityName = activityName;
        this.createdAt = createdAt;
        this.correctCount = correctCount;
        this.wrongCount = wrongCount;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Long correctCount) {
        this.correctCount = correctCount;
    }

    public Long getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(Long wrongCount) {
        this.wrongCount = wrongCount;
    }
}