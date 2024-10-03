package com.g1appdev.Hubbits.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String message;
    private LocalDate feedbackDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    // Getters and Setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }
}
