package com.HMSync.event.management.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class EventDto {
    private UUID eventId;
    private String eventName;
    private String eventType;
    private LocalDate eventDate;
    private String eventStatus;
    private String eventVenue;
}
