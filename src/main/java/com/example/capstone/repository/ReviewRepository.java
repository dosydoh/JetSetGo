package com.example.capstone.repository;

import com.example.capstone.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Review data.
 */
//@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}