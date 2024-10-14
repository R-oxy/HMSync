package com.HMSync.rooms.entity;

import com.HMSync.catalog.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "rooms")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Room extends BaseEntity {
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name = "number_of_beds")
    private int numberOfBeds;

    @Column(name = "room_amenities")
    private String roomAmenities;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "occupancy_status")
    private String occupancyStatus;
}
