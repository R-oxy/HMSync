package com.HMSync.transactions.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TransactionRequestDto {
    private UUID transactionId;

    @NotNull(message = "Booking ID is required")
    private UUID bookingId;

    @NotNull(message = "Transaction date and time is required")
    private LocalDateTime transactionDateTime;

    @NotNull(message = "Transaction amount is required")
    private double transactionAmount;
}
