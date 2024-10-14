package com.HMSync.bookings.controller.dto;

import com.HMSync.authentication.controller.dto.RegistrationDto;
import com.HMSync.rooms.controller.dto.RoomDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class BookingDto {
    private UUID bookingId;
    private RegistrationDto customer;
    private RoomDto room;
    private LocalDate reservationDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double roomPricing;
    private boolean bookingConfirmation;
}
