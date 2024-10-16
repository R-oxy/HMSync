package com.HMSync.bookings.service;

import com.HMSync.bookings.controller.assembler.BookingAssembler;
import com.HMSync.bookings.controller.dto.BookingRequestDto;
import com.HMSync.bookings.entity.Booking;
import com.HMSync.bookings.repository.BookingRepository;
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
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final BookingAssembler bookingAssembler;

    @Override
    public Booking create(BookingRequestDto bookingRequestDto) {
        Booking booking = new Booking();

        return Optional.of(booking)
                .map(entity -> bookingAssembler.toBooking(bookingRequestDto, entity))
                .map(bookingRepository::save)
                .orElseThrow(() -> new RuntimeException("Booking was not saved"));
    }

    @Override
    public Page<Booking> getAll(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }

    @Override
    public Booking update(BookingRequestDto bookingRequestDto) {
        Booking booking = get(bookingRequestDto.getBookingId());
        try {
            return bookingRepository.save(bookingAssembler.toBooking(bookingRequestDto, booking));
        } catch (Exception e) {
            log.error("Error updating booking record: {}", e.getMessage(), e);
            throw new RuntimeException("Booking was not updated due to an unexpected error");
        }
    }

    @Override
    public Booking get(UUID bookingId) {
        return Optional.of(bookingId)
                .flatMap(bookingRepository::findById)
                .orElseThrow(() -> new RuntimeException("Booking with ID: " + bookingId + " does not exist"));
    }

    @Override
    public void delete(UUID bookingId) {
        get(bookingId);
        bookingRepository.deleteById(bookingId);
    }
}
