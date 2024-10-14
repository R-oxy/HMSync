package com.HMSync.bookings.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class BookingRequestDto {
    private UUID bookingId;

    @NotNull(message = "Customer ID is required")
    private UUID customerId;

    @NotNull(message = "Room ID is required")
    private UUID roomId;

    @NotNull(message = "Reservation date is required")
    private LocalDate reservationDate;

    @NotNull(message = "Check-in date is required")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date is required")
    private LocalDate checkOutDate;

    @NotNull(message = "Room pricing is required")
    private double roomPricing;

    @NotNull(message = "Booking confirmation is required")
    private boolean bookingConfirmation;
}
