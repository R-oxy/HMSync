package com.HMSync.reviews.controller;

import com.HMSync.reviews.controller.assembler.ReviewAssembler;
import com.HMSync.reviews.controller.dto.ReviewDto;
import com.HMSync.reviews.controller.dto.ReviewRequestDto;
import com.HMSync.reviews.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "reviews")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewAssembler reviewAssembler;
    private final ReviewService reviewService;

    @GetMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewDto get(@PathVariable UUID reviewId) {
        return reviewAssembler.toReviewDto(reviewService.get(reviewId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDto create(@RequestBody @Valid ReviewRequestDto request) {
        return reviewAssembler.toReviewDto(reviewService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ReviewDto> getAll(Pageable pageable) {
        return reviewService.getAll(pageable).map(reviewAssembler::toReviewDto);
    }

    @PutMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewDto update(@PathVariable("reviewId") UUID reviewId,
                            @RequestBody @Valid ReviewRequestDto reviewRequestDto) {
        if (!reviewId.equals(reviewRequestDto.getReviewId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return reviewAssembler.toReviewDto(reviewService.update(reviewRequestDto));
    }

    @DeleteMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID reviewId) {
        reviewService.delete(reviewId);
    }
}
