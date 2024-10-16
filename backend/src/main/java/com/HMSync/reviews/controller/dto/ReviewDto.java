package com.HMSync.reviews.controller.dto;

import com.HMSync.authentication.controller.dto.RegistrationDto;
import com.HMSync.rooms.controller.dto.RoomDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ReviewDto {
    private UUID reviewId;
    private RegistrationDto guest;
    private RoomDto room;
    private LocalDate reviewDate;
    private int rating;
}
