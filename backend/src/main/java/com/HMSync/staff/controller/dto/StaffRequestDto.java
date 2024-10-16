package com.HMSync.staff.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class StaffRequestDto {
    private UUID staffId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Shift type is required")
    private String shiftType;

    @NotNull(message = "Clock in time is required")
    private LocalDateTime clockInTime;

    @NotNull(message = "Clock out time is required")
    private LocalDateTime clockOutTime;

    @NotBlank(message = "Performance review is required")
    private String performanceReview;

    @NotBlank(message = "Assignment is required")
    private String assignment;
}
