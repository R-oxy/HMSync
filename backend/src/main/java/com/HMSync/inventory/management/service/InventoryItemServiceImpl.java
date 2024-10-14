package com.HMSync.inventory.management.service;

import com.HMSync.inventory.management.controller.assembler.InventoryItemAssembler;
import com.HMSync.inventory.management.controller.dto.InventoryItemRequestDto;
import com.HMSync.inventory.management.entity.InventoryItem;
import com.HMSync.inventory.management.repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService{
    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemAssembler inventoryItemAssembler;

    @Override
    public InventoryItem create(InventoryItemRequestDto inventoryItemRequestDto) {
        InventoryItem inventoryItem = new InventoryItem();

        return Optional.of(inventoryItem)
                .map(entity -> inventoryItemAssembler.toInventoryItem(inventoryItemRequestDto, inventoryItem))
                .map(inventoryItemRepository::save)
                .orElseThrow(() -> new RuntimeException("Inventory Item was not saved"));
    }

    @Override
    public Page<InventoryItem> getAll(Pageable pageable) {
        return inventoryItemRepository.findAll(pageable);
    }

    @Override
    public InventoryItem update(InventoryItemRequestDto inventoryItemRequestDto) {
        InventoryItem inventoryItem = get(inventoryItemRequestDto.getInventoryItemId());
        try {
            return inventoryItemRepository.save(inventoryItemAssembler.toInventoryItem(inventoryItemRequestDto, inventoryItem));
        } catch (Exception e) {
            log.error("Error updating inventory item: {}", e.getMessage(), e);
            throw new RuntimeException("Inventory Item was not updated due to an unexpected error");
        }
    }

    @Override
    public InventoryItem get(UUID inventoryItemId) {
        return Optional.of(inventoryItemId)
                .flatMap(inventoryItemRepository::findById)
                .orElseThrow(() -> new RuntimeException("Inventory Item with ID: " + inventoryItemId + " does not exist"));
    }

    @Override
    public void delete(UUID inventoryItemId) {
        get(inventoryItemId);
        inventoryItemRepository.deleteById(inventoryItemId);
    }
}
