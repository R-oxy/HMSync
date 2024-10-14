package com.HMSync.room.service.service;

import com.HMSync.room.service.controller.dto.RoomServiceRequestDto;
import com.HMSync.room.service.entity.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RoomServiceService {
    RoomService create(RoomServiceRequestDto roomServiceRequestDto);
    Page<RoomService> getAll(Pageable pageable);
    RoomService update(RoomServiceRequestDto roomServiceRequestDto);
    RoomService get(UUID serviceId);
    void delete(UUID serviceId);
}
