package com.HMSync.reports.and.analytics.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class AnalyticsDto {
    private BigDecimal totalRevenue;
    private Map<String, BigDecimal> revenueBreakdown;
    private BigDecimal averageDailyRate;
    private BigDecimal revenuePerAvailableRoom;
    private double occupancyRate;
    private int cancellationsCount;
    private int fulfilledBookingsCount;
    private double averageLengthOfStay;
    private double averageReviewRating;
}
