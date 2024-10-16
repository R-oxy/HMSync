package com.HMSync.event.management.entity;

import com.HMSync.catalog.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "events")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Event extends BaseEntity {
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "event_status")
    private String eventStatus;

    @Column(name = "event_venue")
    private String eventVenue;
}
