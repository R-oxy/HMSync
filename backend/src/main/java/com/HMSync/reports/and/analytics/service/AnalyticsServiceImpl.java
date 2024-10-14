package com.HMSync.reports.and.analytics.service;

import com.HMSync.bookings.entity.Booking;
import com.HMSync.bookings.repository.BookingRepository;
import com.HMSync.reports.and.analytics.controller.dto.AnalyticsDto;
import com.HMSync.reviews.entity.Review;
import com.HMSync.reviews.repository.ReviewRepository;
import com.HMSync.transactions.entity.Transaction;
import com.HMSync.transactions.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {
    private final TransactionRepository transactionRepository;
    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public AnalyticsDto getAnalytics() {
        AnalyticsDto analyticsDto = new AnalyticsDto();

        // Total Revenue
        List<Transaction> transactions = transactionRepository.findAll();
        BigDecimal totalRevenue = transactions.stream()
                .map(transaction -> BigDecimal.valueOf(transaction.getTransactionAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        analyticsDto.setTotalRevenue(totalRevenue);

        // Revenue Breakdown
        Map<String, BigDecimal> revenueBreakdown = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getBooking().getRoom().getRoomType(),
                        Collectors.reducing(BigDecimal.ZERO, transaction -> BigDecimal.valueOf(transaction.getTransactionAmount()), BigDecimal::add)));
        analyticsDto.setRevenueBreakdown(revenueBreakdown);

        // Average Daily Rate
        List<Booking> fulfilledBookings = bookingRepository.findAllByBookingConfirmation(true); // Use boolean instead of String
        BigDecimal totalRevenueFulfilled = fulfilledBookings.stream()
                .map(booking -> BigDecimal.valueOf(booking.getRoomPricing() *
                        booking.getCheckOutDate().toEpochDay() - booking.getCheckInDate().toEpochDay())) // Length of stay
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        analyticsDto.setAverageDailyRate(totalRevenueFulfilled.divide(
                BigDecimal.valueOf(fulfilledBookings.size()),
                BigDecimal.ROUND_HALF_UP));

        // Revenue per Available Room
        int totalRooms = bookingRepository.countAvailableRooms(); // Assume this method exists
        analyticsDto.setRevenuePerAvailableRoom(totalRooms > 0 ?
                totalRevenue.divide(BigDecimal.valueOf(totalRooms),
                        BigDecimal.ROUND_HALF_UP) :
                BigDecimal.ZERO);

        // Occupancy Rate
        int occupiedRooms = bookingRepository.countOccupiedRooms(); // Assume this method exists
        analyticsDto.setOccupancyRate(totalRooms > 0 ?
                ((double) occupiedRooms / totalRooms) * 100 :
                0.0);

        // Cancellations
        int cancellationsCount = bookingRepository.countCancellations(); // Assume this method exists
        analyticsDto.setCancellationsCount(cancellationsCount);

        // Fulfilled Bookings
        analyticsDto.setFulfilledBookingsCount(fulfilledBookings.size());

        // Average Length of Stay
        double averageLengthOfStay = fulfilledBookings.stream()
                .mapToLong(booking ->
                        booking.getCheckOutDate().toEpochDay() - booking.getCheckInDate().toEpochDay()) // Length of stay in days
                .average()
                .orElse(0.0);
        analyticsDto.setAverageLengthOfStay(averageLengthOfStay);

        // Average Review Rating
        List<Review> reviews = reviewRepository.findAll();
        double averageReviewRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
        analyticsDto.setAverageReviewRating(averageReviewRating);

        return analyticsDto;
    }
}
