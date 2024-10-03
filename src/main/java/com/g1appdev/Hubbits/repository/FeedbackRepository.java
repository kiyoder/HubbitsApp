package com.g1appdev.Hubbits.repository;

import com.g1appdev.Hubbits.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
