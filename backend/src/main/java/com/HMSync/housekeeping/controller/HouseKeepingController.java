package com.HMSync.housekeeping.controller;

import com.HMSync.housekeeping.controller.assembler.HouseKeepingAssembler;
import com.HMSync.housekeeping.controller.dto.HouseKeepingDto;
import com.HMSync.housekeeping.controller.dto.HouseKeepingRequestDto;
import com.HMSync.housekeeping.service.HouseKeepingService;
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

@Tag(name = "housekeeping")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/housekeeping")
public class HouseKeepingController {
    private final HouseKeepingAssembler houseKeepingAssembler;
    private final HouseKeepingService houseKeepingService;

    @GetMapping("/{houseKeepingId}")
    @ResponseStatus(HttpStatus.OK)
    public HouseKeepingDto get(@PathVariable UUID houseKeepingId) {
        return houseKeepingAssembler.toHouseKeepingDto(houseKeepingService.get(houseKeepingId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HouseKeepingDto create(@RequestBody @Valid HouseKeepingRequestDto request) {
        return houseKeepingAssembler.toHouseKeepingDto(houseKeepingService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<HouseKeepingDto> getAll(Pageable pageable) {
        return houseKeepingService.getAll(pageable).map(houseKeepingAssembler::toHouseKeepingDto);
    }

    @PutMapping("/{houseKeepingId}")
    @ResponseStatus(HttpStatus.OK)
    public HouseKeepingDto update(@PathVariable("houseKeepingId") UUID houseKeepingId,
                                  @RequestBody HouseKeepingRequestDto houseKeepingRequestDto) {
        if (!houseKeepingId.equals(houseKeepingRequestDto.getHouseKeepingId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return houseKeepingAssembler.toHouseKeepingDto(houseKeepingService.update(houseKeepingRequestDto));
    }

    @DeleteMapping("/{houseKeepingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID houseKeepingId) {
        houseKeepingService.delete(houseKeepingId);
    }
}
