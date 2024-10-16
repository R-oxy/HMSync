package com.HMSync.room.service.service;

import com.HMSync.room.service.controller.assembler.RoomServiceAssembler;
import com.HMSync.room.service.controller.dto.RoomServiceRequestDto;
import com.HMSync.room.service.entity.RoomService;
import com.HMSync.room.service.repository.RoomServiceRepository;
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
public class RoomServiceServiceImpl implements RoomServiceService{
    private final RoomServiceRepository roomServiceRepository;
    private final RoomServiceAssembler roomServiceAssembler;

    @Override
    public RoomService create(RoomServiceRequestDto roomServiceRequestDto) {
        RoomService roomService = new RoomService();
        return Optional.of(roomService)
                .map(entity -> roomServiceAssembler.toRoomService(roomServiceRequestDto, roomService))
                .map(roomServiceRepository::save)
                .orElseThrow(() -> new RuntimeException("Room service was not saved"));
    }

    @Override
    public Page<RoomService> getAll(Pageable pageable) {
        return roomServiceRepository.findAll(pageable);
    }

    @Override
    public RoomService update(RoomServiceRequestDto roomServiceRequestDto) {
        RoomService roomService = get(roomServiceRequestDto.getServiceId());
        try {
            return roomServiceRepository.save(roomServiceAssembler.toRoomService(roomServiceRequestDto, roomService));
        } catch (Exception e) {
            log.error("Error updating room service: {}", e.getMessage(), e);
            throw new RuntimeException("Room service was not updated due to an unexpected error");
        }
    }

    @Override
    public RoomService get(UUID serviceId) {
        return Optional.of(serviceId)
                .flatMap(roomServiceRepository::findById)
                .orElseThrow(() -> new RuntimeException("Room service with ID: " + serviceId + " does not exist"));
    }

    @Override
    public void delete(UUID serviceId) {
        get(serviceId);
        roomServiceRepository.deleteById(serviceId);
    }
}
