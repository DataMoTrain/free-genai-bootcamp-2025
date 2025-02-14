package com.example.genaibootcamp.tahir.langportal.langportal.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "study_sessions")
public class StudySessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Groups group;

    @ManyToOne
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivities studyActivity;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public StudyActivities getStudyActivity() {
        return studyActivity;
    }

    public void setStudyActivity(StudyActivities studyActivity) {
        this.studyActivity = studyActivity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}