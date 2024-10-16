package com.HMSync.transactions.controller.assembler;

import com.HMSync.bookings.controller.assembler.BookingAssembler;
import com.HMSync.bookings.entity.Booking;
import com.HMSync.bookings.service.BookingService;
import com.HMSync.transactions.controller.dto.TransactionDto;
import com.HMSync.transactions.controller.dto.TransactionRequestDto;
import com.HMSync.transactions.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionAssembler {
    private final BookingAssembler bookingAssembler;
    private final BookingService bookingService;

    public TransactionDto toTransactionDto(Transaction from) {
        TransactionDto to = new TransactionDto();
        to.setTransactionId(from.getId());
        to.setTransactionDateTime(from.getTransactionDateTime());
        to.setTransactionAmount(from.getTransactionAmount());

        if (from.getBooking() != null) {
            to.setBooking(bookingAssembler.toBookingDto(from.getBooking()));
        }

        return to;
    }

    public Transaction toTransaction(TransactionRequestDto from, Transaction to) {
        Booking booking = bookingService.get(from.getBookingId());
        to.setBooking(booking);
        to.setTransactionDateTime(from.getTransactionDateTime());
        to.setTransactionAmount(from.getTransactionAmount());
        return to;
    }
}
