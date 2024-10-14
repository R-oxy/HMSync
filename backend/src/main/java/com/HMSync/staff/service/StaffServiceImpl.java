package com.HMSync.staff.service;

import com.HMSync.staff.controller.assembler.StaffAssembler;
import com.HMSync.staff.controller.dto.StaffRequestDto;
import com.HMSync.staff.entity.Staff;
import com.HMSync.staff.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService{
    private final StaffRepository staffRepository;
    private final StaffAssembler staffAssembler;

    @Override
    public Staff create(StaffRequestDto staffRequestDto) {
        Staff staff = new Staff();

        return Optional.of(staff)
                .map(entity -> staffAssembler.toStaff(staffRequestDto, staff))
                .map(staffRepository::save)
                .orElseThrow(() -> new RuntimeException("Staff was not saved"));
    }

    @Override
    public Page<Staff> getAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff update(StaffRequestDto staffRequestDto) {
        Staff staff = get(staffRequestDto.getStaffId());
        try {
            return staffRepository.save(staffAssembler.toStaff(staffRequestDto, staff));
        } catch (Exception e) {
            log.error("Error updating staff: {}", e.getMessage(), e);
            throw new RuntimeException("Staff was not updated due to an unexpected error");
        }
    }

    @Override
    public Staff get(UUID staffId) {
        return Optional.of(staffId)
                .flatMap(staffRepository::findById)
                .orElseThrow(() -> new RuntimeException("Staff with ID: " + staffId + " does not exist"));
    }

    @Override
    public void delete(UUID staffId) {
        get(staffId);
        staffRepository.deleteById(staffId);
    }
}
