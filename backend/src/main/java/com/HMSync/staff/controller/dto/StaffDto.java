package com.HMSync.staff.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class StaffDto {
    private UUID staffId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String jobTitle;
    private String department;
    private String shiftType;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private String performanceReview;
    private String assignment;
}
