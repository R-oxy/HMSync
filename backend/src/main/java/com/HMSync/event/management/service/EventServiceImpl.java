package com.HMSync.event.management.service;

import com.HMSync.event.management.controller.assembler.EventAssembler;
import com.HMSync.event.management.controller.dto.EventRequestDto;
import com.HMSync.event.management.entity.Event;
import com.HMSync.event.management.repository.EventRepository;
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
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventAssembler eventAssembler;

    @Override
    public Event create(EventRequestDto eventRequestDto) {
        Event event = new Event();
        return Optional.of(event)
                .map(entity -> eventAssembler.toEvent(eventRequestDto, event))
                .map(eventRepository::save)
                .orElseThrow(() -> new RuntimeException("Event was not saved"));
    }

    @Override
    public Page<Event> getAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    public Event update(EventRequestDto eventRequestDto) {
        Event event = get(eventRequestDto.getEventId());
        try {
            return eventRepository.save(eventAssembler.toEvent(eventRequestDto, event));
        } catch (Exception e) {
            log.error("Error updating event: {}", e.getMessage(), e);
            throw new RuntimeException("Event was not updated due to an unexpected error");
        }
    }

    @Override
    public Event get(UUID eventId) {
        return Optional.of(eventId)
                .flatMap(eventRepository::findById)
                .orElseThrow(() -> new RuntimeException("Event with ID: " + eventId + " does not exist"));
    }

    @Override
    public void delete(UUID eventId) {
        get(eventId);
        eventRepository.deleteById(eventId);
    }
}
