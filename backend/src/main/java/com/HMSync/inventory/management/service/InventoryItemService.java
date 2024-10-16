package com.HMSync.inventory.management.service;

import com.HMSync.inventory.management.controller.dto.InventoryItemRequestDto;
import com.HMSync.inventory.management.entity.InventoryItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface InventoryItemService {
    InventoryItem create(InventoryItemRequestDto inventoryItemRequestDto);
    Page<InventoryItem> getAll(Pageable pageable);
    InventoryItem update(InventoryItemRequestDto inventoryItemRequestDto);
    InventoryItem get(UUID inventoryItemId);
    void delete(UUID inventoryItemId);
}
