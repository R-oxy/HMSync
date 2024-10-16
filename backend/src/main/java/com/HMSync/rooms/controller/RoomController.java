package com.HMSync.rooms.controller;

import com.HMSync.rooms.controller.assembler.RoomAssembler;
import com.HMSync.rooms.controller.dto.RoomDto;
import com.HMSync.rooms.controller.dto.RoomRequestDto;
import com.HMSync.rooms.service.RoomService;
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

@Tag(name = "rooms")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomAssembler roomAssembler;
    private final RoomService roomService;

    @GetMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public RoomDto get(@PathVariable UUID roomId) {
        return roomAssembler.toRoomDto(roomService.get(roomId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto create(@RequestBody @Valid RoomRequestDto request) {
        return roomAssembler.toRoomDto(roomService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RoomDto> getAll(Pageable pageable) {
        return roomService.getAll(pageable).map(roomAssembler::toRoomDto);
    }

    @PutMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public RoomDto update(@PathVariable("roomId") UUID roomId, @RequestBody RoomRequestDto roomRequestDto) {
        if (!roomId.equals(roomRequestDto.getRoomId())) {
            throw new RuntimeException("Path ID does not exist");
        }
        return roomAssembler.toRoomDto(roomService.update(roomRequestDto));
    }

    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID roomId) {
        roomService.delete(roomId);
    }
}
