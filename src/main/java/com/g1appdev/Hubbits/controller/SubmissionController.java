package com.g1appdev.Hubbits.controller;

import com.g1appdev.Hubbits.entity.Submission;
import com.g1appdev.Hubbits.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable Long id) {
        Submission submission = submissionService.getSubmissionById(id);
        return submission != null ? ResponseEntity.ok(submission) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Submission createSubmission(@RequestBody Submission submission) {
        return submissionService.createSubmission(submission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submissionDetails) {
        Submission updatedSubmission = submissionService.updateSubmission(id, submissionDetails);
        return updatedSubmission != null ? ResponseEntity.ok(updatedSubmission) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.noContent().build();
    }
}
