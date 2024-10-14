package com.HMSync.inventory.management.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class InventoryItemDto {
    private UUID inventoryItemId;
    private String itemName;
    private String itemDescription;
    private String supplier;
    private String availabilityStatus;
    private int quantityAvailable;
}
