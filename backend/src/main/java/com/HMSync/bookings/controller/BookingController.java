package com.HMSync.bookings.controller;

import com.HMSync.bookings.controller.assembler.BookingAssembler;
import com.HMSync.bookings.controller.dto.BookingDto;
import com.HMSync.bookings.controller.dto.BookingRequestDto;
import com.HMSync.bookings.service.BookingService;
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

@Tag(name = "bookings")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingAssembler bookingAssembler;
    private final BookingService bookingService;

    @GetMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDto get(@PathVariable UUID bookingId) {
        return bookingAssembler.toBookingDto(bookingService.get(bookingId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto create(@RequestBody @Valid BookingRequestDto request) {
        return bookingAssembler.toBookingDto(bookingService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<BookingDto> getAll(Pageable pageable) {
        return bookingService.getAll(pageable).map(bookingAssembler::toBookingDto);
    }

    @PutMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDto update(@PathVariable("bookingId") UUID bookingId,
                             @RequestBody @Valid BookingRequestDto bookingRequestDto) {
        if (!bookingId.equals(bookingRequestDto.getBookingId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return bookingAssembler.toBookingDto(bookingService.update(bookingRequestDto));
    }

    @DeleteMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID bookingId) {
        bookingService.delete(bookingId);
    }
}
