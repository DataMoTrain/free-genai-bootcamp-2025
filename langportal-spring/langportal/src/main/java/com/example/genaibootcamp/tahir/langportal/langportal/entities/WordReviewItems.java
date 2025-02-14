package com.example.genaibootcamp.tahir.langportal.langportal.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "word_review_items")
public class WordReviewItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false)
    private Words word;

    @ManyToOne
    @JoinColumn(name = "study_session_id", nullable = false)
    private StudySessions studySession;

    @Column(name = "result", nullable = false)
    private Boolean result;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

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

    public StudySessions getStudySession() {
        return studySession;
    }

    public void setStudySession(StudySessions studySession) {
        this.studySession = studySession;
    }

    public Boolean getResult() {
        return result;
    }

    @ManyToOne    public void setResult(Boolean result) {
        this.result = result;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
