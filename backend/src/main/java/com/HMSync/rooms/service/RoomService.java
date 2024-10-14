package com.HMSync.rooms.service;

import com.HMSync.rooms.controller.dto.RoomRequestDto;
import com.HMSync.rooms.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RoomService {
    Room create(RoomRequestDto roomRequestDto);
    Page<Room> getAll(Pageable pageable);
    Room update(RoomRequestDto roomRequestDto);
    Room get(UUID roomId);
    void delete(UUID roomId);
}
