package com.example.capstone.services;

import com.example.capstone.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.example.capstone.model.Review;
import com.example.capstone.repository.ReviewRepository;

/**
 * Service implementation for handling Review operations.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(Long id, Review review) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id " + id);
        }
        review.setId(id);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id " + id);
        }
        reviewRepository.deleteById(id);
    }
}