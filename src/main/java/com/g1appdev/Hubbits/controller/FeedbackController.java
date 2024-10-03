package com.g1appdev.Hubbits.controller;

import com.g1appdev.Hubbits.entity.Feedback;
import com.g1appdev.Hubbits.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return feedback != null ? ResponseEntity.ok(feedback) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedbackDetails);
        return updatedFeedback != null ? ResponseEntity.ok(updatedFeedback) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            feedbackService.deleteFeedback(id);
            return ResponseEntity.noContent().build();  // HTTP 204 No Content
        }
        return ResponseEntity.notFound().build();  // HTTP 404 Not Found
    }

}

