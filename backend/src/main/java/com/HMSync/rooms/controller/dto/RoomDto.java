package com.HMSync.rooms.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class RoomDto {
    private UUID roomId;
    private String roomNumber;
    private String roomCategory;
    private String roomType;
    private int floorNumber;
    private int numberOfBeds;
    private String roomAmenities;
    private String specialFeatures;
    private String occupancyStatus;
}
