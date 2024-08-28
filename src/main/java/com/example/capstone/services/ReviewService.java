package com.example.capstone.services;

import java.util.List;
import com.example.capstone.model.Review;

/**
 * Service interface for handling Review operations.
 */
public interface ReviewService {
    Review createReview(Review review);
    Review getReviewById(Long id);
    List<Review> getAllReviews();
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
}