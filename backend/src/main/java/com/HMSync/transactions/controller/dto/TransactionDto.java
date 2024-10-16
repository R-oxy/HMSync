package com.HMSync.transactions.controller.dto;

import com.HMSync.bookings.controller.dto.BookingDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TransactionDto {
    private UUID transactionId;
    private BookingDto booking;
    private LocalDateTime transactionDateTime;
    private double transactionAmount;
}
