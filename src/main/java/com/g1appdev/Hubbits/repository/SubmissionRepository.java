package com.g1appdev.Hubbits.repository;


import com.g1appdev.Hubbits.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    // Custom query methods (if needed) can be defined here
}