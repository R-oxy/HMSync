package com.HMSync.bookings.service;

import com.HMSync.bookings.controller.dto.BookingRequestDto;
import com.HMSync.bookings.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookingService {
    Booking create(BookingRequestDto bookingRequestDto);
    Page<Booking> getAll(Pageable pageable);
    Booking update(BookingRequestDto bookingRequestDto);
    Booking get(UUID bookingId);
    void delete(UUID bookingId);
}
