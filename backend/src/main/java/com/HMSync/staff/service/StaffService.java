package com.HMSync.staff.service;

import com.HMSync.staff.controller.dto.StaffRequestDto;
import com.HMSync.staff.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StaffService {
    Staff create(StaffRequestDto staffRequestDto);
    Page<Staff> getAll(Pageable pageable);
    Staff update(StaffRequestDto staffRequestDto);
    Staff get(UUID staffId);
    void delete(UUID staffId);
}
