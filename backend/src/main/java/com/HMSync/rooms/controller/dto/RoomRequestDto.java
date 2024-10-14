package com.HMSync.rooms.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class RoomRequestDto {
    private UUID roomId;

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotBlank(message = "Room category is required")
    private String roomCategory;

    @NotBlank(message = "Room type is required")
    private String roomType;

    @NotNull(message = "Floor number is required")
    private Integer floorNumber;

    @NotNull(message = "Number of beds is required")
    private Integer numberOfBeds;

    private String roomAmenities;
    private String specialFeatures;
    private String occupancyStatus;
}
