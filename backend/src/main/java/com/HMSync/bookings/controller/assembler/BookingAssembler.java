package com.HMSync.bookings.controller.assembler;

import com.HMSync.authentication.controller.assembler.RegistrationAssembler;
import com.HMSync.bookings.controller.dto.BookingDto;
import com.HMSync.bookings.controller.dto.BookingRequestDto;
import com.HMSync.bookings.entity.Booking;
import com.HMSync.rooms.controller.assembler.RoomAssembler;
import com.HMSync.rooms.entity.Room;
import com.HMSync.rooms.service.RoomService;
import com.HMSync.security.user.entity.User;
import com.HMSync.security.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingAssembler {
    private final RoomAssembler roomAssembler;
    private final RegistrationAssembler registrationAssembler;
    private final RoomService roomService;
    private final UserService userService;

    public BookingDto toBookingDto(Booking from) {
        BookingDto to = new BookingDto();
        to.setBookingId(from.getId());
        to.setReservationDate(from.getReservationDate());
        to.setCheckInDate(from.getCheckInDate());
        to.setCheckOutDate(from.getCheckOutDate());
        to.setRoomPricing(from.getRoomPricing());
        to.setBookingConfirmation(from.isBookingConfirmation());

        if (from.getRoom() != null) {
            to.setRoom(roomAssembler.toRoomDto(from.getRoom()));
        }

        if (from.getCustomer() != null) {
            to.setCustomer(registrationAssembler.toRegistrationDto(from.getCustomer()));
        }

        return to;
    }

    public Booking toBooking(BookingRequestDto from, Booking to) {
        Room room = roomService.get(from.getRoomId());
        User customer = userService.get(from.getCustomerId());
        to.setRoom(room);
        to.setCustomer(customer);
        to.setReservationDate(from.getReservationDate());
        to.setCheckInDate(from.getCheckInDate());
        to.setCheckOutDate(from.getCheckOutDate());
        to.setRoomPricing(from.getRoomPricing());
        to.setBookingConfirmation(from.isBookingConfirmation());
        return to;
    }
}
