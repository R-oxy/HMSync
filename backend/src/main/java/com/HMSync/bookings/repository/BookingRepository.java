package com.HMSync.bookings.repository;

import com.HMSync.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findAllByBookingConfirmation(boolean bookingConfirmation);

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.bookingConfirmation = true")
    int countFulfilledBookings(); // Count of fulfilled bookings

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.checkOutDate < CURRENT_DATE")
    int countOccupiedRooms(); // Assumes you want to count all bookings that have checked out

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.bookingConfirmation = false")
    int countCancellations(); // Count of cancellations

    @Query("SELECT COUNT(r) FROM Room r")
    int countAvailableRooms(); // Add this method to count total available rooms
}
