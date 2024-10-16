package com.HMSync.inventory.management.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class InventoryItemRequestDto {
    private UUID inventoryItemId;

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotBlank(message = "Item description is required")
    private String itemDescription;

    @NotBlank(message = "Supplier is required")
    private String supplier;

    @NotBlank(message = "Availability status is required")
    private String availabilityStatus;

    @NotNull(message = "Quantity available is required")
    private int quantityAvailable;
}
