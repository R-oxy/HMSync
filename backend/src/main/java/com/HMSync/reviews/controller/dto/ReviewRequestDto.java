package com.HMSync.reviews.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ReviewRequestDto {
    private UUID reviewId;

    @NotNull(message = "Guest ID is required")
    private UUID guestId;

    @NotNull(message = "Room ID is required")
    private UUID roomId;

    @NotNull(message = "Review date is required")
    private LocalDate reviewDate;

    @NotNull(message = "Rating is required")
    private int rating;
}
