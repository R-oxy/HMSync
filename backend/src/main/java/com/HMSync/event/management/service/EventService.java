package com.HMSync.event.management.service;

import com.HMSync.event.management.controller.dto.EventRequestDto;
import com.HMSync.event.management.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EventService {
    Event create(EventRequestDto eventRequestDto);
    Page<Event> getAll(Pageable pageable);
    Event update(EventRequestDto eventRequestDto);
    Event get(UUID eventId);
    void delete(UUID eventId);
}
