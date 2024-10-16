package com.HMSync.reviews.service;

import com.HMSync.reviews.controller.assembler.ReviewAssembler;
import com.HMSync.reviews.controller.dto.ReviewRequestDto;
import com.HMSync.reviews.entity.Review;
import com.HMSync.reviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final ReviewAssembler reviewAssembler;

    @Override
    public Review create(ReviewRequestDto reviewRequestDto) {
        Review review = new Review();
        return Optional.of(review)
                .map(entity -> reviewAssembler.toReview(reviewRequestDto, entity))
                .map(reviewRepository::save)
                .orElseThrow(() -> new RuntimeException("Review was not saved"));
    }

    @Override
    public Page<Review> getAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Review update(ReviewRequestDto reviewRequestDto) {
        Review review = get(reviewRequestDto.getReviewId());
        try {
            return reviewRepository.save(reviewAssembler.toReview(reviewRequestDto, review));
        } catch (Exception e) {
            log.error("Error updating review: {}", e.getMessage(), e);
            throw new RuntimeException("Review was not updated due to an unexpected error");
        }
    }

    @Override
    public Review get(UUID reviewId) {
        return Optional.of(reviewId)
                .flatMap(reviewRepository::findById)
                .orElseThrow(() -> new RuntimeException("Review with ID: " + reviewId + " does not exist"));
    }

    @Override
    public void delete(UUID reviewId) {
        get(reviewId);
        reviewRepository.deleteById(reviewId);
    }
}
