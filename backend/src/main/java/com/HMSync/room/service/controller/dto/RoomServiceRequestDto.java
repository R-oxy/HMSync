package com.HMSync.room.service.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class RoomServiceRequestDto {
    private UUID serviceId;

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotBlank(message = "Item category is required")
    private String itemCategory;

    @NotNull(message = "Price is required")
    private double price;

    @NotNull(message = "Availability is required")
    private boolean availability;

    private String customizations;
}
