package com.HMSync.staff.controller;

import com.HMSync.staff.controller.assembler.StaffAssembler;
import com.HMSync.staff.controller.dto.StaffDto;
import com.HMSync.staff.controller.dto.StaffRequestDto;
import com.HMSync.staff.service.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "staff")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
    private final StaffService staffService;
    private final StaffAssembler staffAssembler;

    @GetMapping("/{staffId}")
    @ResponseStatus(HttpStatus.OK)
    public StaffDto get(@PathVariable UUID staffId) {
        return staffAssembler.toStaffDto(staffService.get(staffId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StaffDto create(@RequestBody @Valid StaffRequestDto request) {
        return staffAssembler.toStaffDto(staffService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StaffDto> getAll(Pageable pageable) {
        return staffService.getAll(pageable)
                .map(staffAssembler::toStaffDto);
    }

    @PutMapping("/{staffId}")
    @ResponseStatus(HttpStatus.OK)
    public StaffDto update(@PathVariable UUID staffId, @RequestBody StaffRequestDto staffRequestDto) {
        if (!staffId.equals(staffRequestDto.getStaffId())) {
            throw new RuntimeException("Path ID does not exist");
        }
        return staffAssembler.toStaffDto(staffService.update(staffRequestDto));
    }

    @DeleteMapping("/{staffId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID staffId) {
        staffService.delete(staffId);
    }
}
