package com.HMSync.reviews.service;

import com.HMSync.reviews.controller.dto.ReviewRequestDto;
import com.HMSync.reviews.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ReviewService {
    Review create(ReviewRequestDto reviewRequestDto);
    Page<Review> getAll(Pageable pageable);
    Review update(ReviewRequestDto reviewRequestDto);
    Review get(UUID reviewId);
    void delete(UUID reviewId);
}
