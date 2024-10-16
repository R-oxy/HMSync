package com.HMSync.housekeeping.service;

import com.HMSync.housekeeping.controller.dto.HouseKeepingRequestDto;
import com.HMSync.housekeeping.entity.HouseKeeping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HouseKeepingService {
    HouseKeeping create(HouseKeepingRequestDto houseKeepingRequestDto);
    Page<HouseKeeping> getAll(Pageable pageable);
    HouseKeeping update(HouseKeepingRequestDto houseKeepingRequestDto);
    HouseKeeping get(UUID houseKeepingId);
    void delete(UUID houseKeepingId);
}
