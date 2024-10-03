package com.g1appdev.Hubbits.service;

import com.g1appdev.Hubbits.entity.Feedback;
import com.g1appdev.Hubbits.entity.Submission;
import com.g1appdev.Hubbits.repository.FeedbackRepository;
import com.g1appdev.Hubbits.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public Feedback createFeedback(Feedback feedback) {
        // Fetch the submission from the database using submissionId
        Submission submission = submissionRepository.findById(feedback.getSubmission().getSubmissionId()).orElse(null);
        if (submission != null) {
            feedback.setSubmission(submission);  // Set the fetched submission object to the feedback

            // Save the feedback first
            Feedback savedFeedback = feedbackRepository.save(feedback);

            // Now set the feedback in the submission and save the submission again
            submission.setFeedback(savedFeedback);  // Set the feedback in the submission
            submissionRepository.save(submission);  // Update the submission with feedback reference

            return savedFeedback;
        } else {
            throw new IllegalArgumentException("Invalid submissionId: " + feedback.getSubmission().getSubmissionId());
        }
    }

    public Feedback updateFeedback(Long id, Feedback feedbackDetails) {
        Feedback feedback = feedbackRepository.findById(id).orElse(null);
        if (feedback != null) {
            feedback.setMessage(feedbackDetails.getMessage());
            feedback.setFeedbackDate(feedbackDetails.getFeedbackDate());
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    public void deleteFeedback(Long id) {
        try {
            feedbackRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting feedback with id " + id + ": " + e.getMessage());
            throw e; // Or handle it in a way that fits your application
        }
    }
}
