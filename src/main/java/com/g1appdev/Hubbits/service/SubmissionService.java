package com.g1appdev.Hubbits.service;


import com.g1appdev.Hubbits.entity.Submission;
import com.g1appdev.Hubbits.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission getSubmissionById(Long id) {
        return submissionRepository.findById(id).orElse(null);
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission updateSubmission(Long id, Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id).orElse(null);
        if (submission != null) {
            submission.setType(submissionDetails.getType());
            submission.setStatus(submissionDetails.getStatus());
            submission.setFileLink(submissionDetails.getFileLink());
            submission.setGrade(submissionDetails.getGrade());
            return submissionRepository.save(submission);
        }
        return null;
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}
