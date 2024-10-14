package com.HMSync.bookings.entity;

import com.HMSync.catalog.entity.BaseEntity;
import com.HMSync.rooms.entity.Room;
import com.HMSync.security.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Booking extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "room_pricing")
    private double roomPricing;

    @Column(name = "booking_confirmation")
    private boolean bookingConfirmation;
}
