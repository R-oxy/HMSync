package com.HMSync.staff.controller.assembler;

import com.HMSync.staff.controller.dto.StaffDto;
import com.HMSync.staff.controller.dto.StaffRequestDto;
import com.HMSync.staff.entity.Staff;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StaffAssembler {
    public StaffDto toStaffDto(Staff from) {
        StaffDto to = new StaffDto();
        to.setStaffId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setJobTitle(from.getJobTitle());
        to.setDepartment(from.getDepartment());
        to.setShiftType(from.getShiftType());
        to.setClockInTime(from.getClockInTime());
        to.setClockOutTime(from.getClockOutTime());
        to.setPerformanceReview(from.getPerformanceReview());
        to.setAssignment(from.getAssignment());
        return to;
    }

    public Staff toStaff(StaffRequestDto from, Staff to) {
        to.setId(from.getStaffId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setJobTitle(from.getJobTitle());
        to.setDepartment(from.getDepartment());
        to.setShiftType(from.getShiftType());
        to.setClockInTime(from.getClockInTime());
        to.setClockOutTime(from.getClockOutTime());
        to.setPerformanceReview(from.getPerformanceReview());
        to.setAssignment(from.getAssignment());
        return to;
    }
}
