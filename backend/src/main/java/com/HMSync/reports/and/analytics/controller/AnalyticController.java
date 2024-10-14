package com.HMSync.reports.and.analytics.controller;

import com.HMSync.reports.and.analytics.controller.dto.AnalyticsDto;
import com.HMSync.reports.and.analytics.service.AnalyticsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "analytics")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticController {
    private final AnalyticsService analyticsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AnalyticsDto getAnalytics() {
        return analyticsService.getAnalytics();
    }
}
