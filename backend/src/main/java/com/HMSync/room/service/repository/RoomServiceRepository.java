package com.HMSync.room.service.repository;

import com.HMSync.room.service.entity.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomServiceRepository extends JpaRepository<RoomService, UUID> {
}
