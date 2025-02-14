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

    @Column(name = "correct", nullable = false)
    private Boolean correct;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Default constructor
    public WordReviewItems() {}

    // Constructor with parameters
    public WordReviewItems(Words word, StudySessions studySession, Boolean correct, LocalDateTime createdAt) {
        this.word = word;
        this.studySession = studySession;
        this.correct = correct;
        this.createdAt = createdAt;
    }

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

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
