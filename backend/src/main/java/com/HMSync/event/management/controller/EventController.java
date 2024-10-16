package com.HMSync.event.management.controller;

import com.HMSync.event.management.controller.assembler.EventAssembler;
import com.HMSync.event.management.controller.dto.EventDto;
import com.HMSync.event.management.controller.dto.EventRequestDto;
import com.HMSync.event.management.service.EventService;
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

@Tag(name = "events")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventAssembler eventAssembler;
    private final EventService eventService;

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventDto get(@PathVariable UUID eventId) {
        return eventAssembler.toEventDto(eventService.get(eventId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto create(@RequestBody @Valid EventRequestDto request) {
        return eventAssembler.toEventDto(eventService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<EventDto> getAll(Pageable pageable) {
        return eventService.getAll(pageable).map(eventAssembler::toEventDto);
    }

    @PutMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventDto update(@PathVariable("eventId") UUID eventId,
                           @RequestBody EventRequestDto eventRequestDto) {
        if (!eventId.equals(eventRequestDto.getEventId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return eventAssembler.toEventDto(eventService.update(eventRequestDto));
    }

    @DeleteMapping("/{eventId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID eventId) {
        eventService.delete(eventId);
    }
}
