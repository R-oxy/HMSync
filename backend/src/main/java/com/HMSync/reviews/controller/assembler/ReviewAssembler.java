package com.HMSync.reviews.controller.assembler;

import com.HMSync.authentication.controller.assembler.RegistrationAssembler;
import com.HMSync.reviews.controller.dto.ReviewDto;
import com.HMSync.reviews.controller.dto.ReviewRequestDto;
import com.HMSync.reviews.entity.Review;
import com.HMSync.rooms.controller.assembler.RoomAssembler;
import com.HMSync.rooms.entity.Room;
import com.HMSync.rooms.service.RoomService;
import com.HMSync.security.user.entity.User;
import com.HMSync.security.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReviewAssembler {
    private final RoomAssembler roomAssembler;
    private final RegistrationAssembler registrationAssembler;
    private final RoomService roomService;
    private final UserService userService;

    public ReviewDto toReviewDto(Review from) {
        ReviewDto to = new ReviewDto();
        to.setReviewId(from.getId());
        to.setReviewDate(from.getReviewDate());
        to.setRating(from.getRating());

        if (from.getRoom() != null) {
            to.setRoom(roomAssembler.toRoomDto(from.getRoom()));
        }

        if (from.getGuest() != null) {
            to.setGuest(registrationAssembler.toRegistrationDto(from.getGuest()));
        }

        return to;
    }

    public Review toReview(ReviewRequestDto from, Review to) {
        Room room = roomService.get(from.getRoomId());
        User guest = userService.get(from.getGuestId());
        to.setRoom(room);
        to.setGuest(guest);
        to.setReviewDate(from.getReviewDate());
        to.setRating(from.getRating());
        return to;
    }
}
