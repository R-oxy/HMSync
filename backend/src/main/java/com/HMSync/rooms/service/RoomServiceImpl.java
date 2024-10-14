package com.HMSync.rooms.service;

import com.HMSync.rooms.controller.assembler.RoomAssembler;
import com.HMSync.rooms.controller.dto.RoomRequestDto;
import com.HMSync.rooms.entity.Room;
import com.HMSync.rooms.repository.RoomRepository;
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
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    private final RoomAssembler roomAssembler;

    @Override
    public Room create(RoomRequestDto roomRequestDto) {
        Room room = new Room();

        return Optional.of(room)
                .map(entity -> roomAssembler.toRoom(roomRequestDto, room))
                .map(roomRepository::save)
                .orElseThrow(() -> new RuntimeException("Room was not saved"));
    }

    @Override
    public Page<Room> getAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Room update(RoomRequestDto roomRequestDto) {
        Room room = get(roomRequestDto.getRoomId());
        try {
            return roomRepository.save(roomAssembler.toRoom(roomRequestDto, room));
        } catch (Exception e) {
            log.error("Error updating room: {}", e.getMessage(), e);
            throw new RuntimeException("Room was not updated due to an unexpected error");
        }
    }

    @Override
    public Room get(UUID roomId) {
        return Optional.of(roomId)
                .flatMap(roomRepository::findById)
                .orElseThrow(() -> new RuntimeException("Room with ID: " + roomId + " does not exist"));
    }

    @Override
    public void delete(UUID roomId) {
        get(roomId);
        roomRepository.deleteById(roomId);
    }
}
