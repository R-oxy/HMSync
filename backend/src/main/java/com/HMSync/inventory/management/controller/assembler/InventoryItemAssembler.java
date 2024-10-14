package com.HMSync.inventory.management.controller.assembler;

import com.HMSync.inventory.management.controller.dto.InventoryItemDto;
import com.HMSync.inventory.management.controller.dto.InventoryItemRequestDto;
import com.HMSync.inventory.management.entity.InventoryItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryItemAssembler {
    public InventoryItemDto toInventoryItemDto(InventoryItem from) {
        InventoryItemDto to = new InventoryItemDto();
        to.setInventoryItemId(from.getId());
        to.setItemName(from.getItemName());
        to.setItemDescription(from.getItemDescription());
        to.setSupplier(from.getSupplier());
        to.setAvailabilityStatus(from.getAvailabilityStatus());
        to.setQuantityAvailable(from.getQuantityAvailable());
        return to;
    }

    public InventoryItem toInventoryItem(InventoryItemRequestDto from, InventoryItem to) {
        to.setId(from.getInventoryItemId());
        to.setItemName(from.getItemName());
        to.setItemDescription(from.getItemDescription());
        to.setSupplier(from.getSupplier());
        to.setAvailabilityStatus(from.getAvailabilityStatus());
        to.setQuantityAvailable(from.getQuantityAvailable());
        return to;
    }
}
