package com.HMSync.transactions.entity;

import com.HMSync.bookings.entity.Booking;
import com.HMSync.catalog.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Transaction extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "transaction_date_time")
    private LocalDateTime transactionDateTime;

    @Column(name = "transaction_amount")
    private double transactionAmount;
}
