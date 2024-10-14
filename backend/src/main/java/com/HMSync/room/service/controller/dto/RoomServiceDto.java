package com.HMSync.room.service.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class RoomServiceDto {
    private UUID serviceId;
    private String itemName;
    private String itemCategory;
    private double price;
    private boolean availability;
    private String customizations;
}
