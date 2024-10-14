package com.HMSync.event.management.controller.assembler;

import com.HMSync.event.management.controller.dto.EventDto;
import com.HMSync.event.management.controller.dto.EventRequestDto;
import com.HMSync.event.management.entity.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventAssembler {
    public EventDto toEventDto(Event from) {
        EventDto to = new EventDto();
        to.setEventId(from.getId());
        to.setEventName(from.getEventName());
        to.setEventType(from.getEventType());
        to.setEventDate(from.getEventDate());
        to.setEventStatus(from.getEventStatus());
        to.setEventVenue(from.getEventVenue());
        return to;
    }

    public Event toEvent(EventRequestDto from, Event to) {
        to.setId(from.getEventId());
        to.setEventName(from.getEventName());
        to.setEventType(from.getEventType());
        to.setEventDate(from.getEventDate());
        to.setEventStatus(from.getEventStatus());
        to.setEventVenue(from.getEventVenue());
        return to;
    }
}
