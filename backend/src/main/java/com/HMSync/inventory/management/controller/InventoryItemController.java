package com.HMSync.inventory.management.controller;

import com.HMSync.inventory.management.controller.assembler.InventoryItemAssembler;
import com.HMSync.inventory.management.controller.dto.InventoryItemDto;
import com.HMSync.inventory.management.controller.dto.InventoryItemRequestDto;
import com.HMSync.inventory.management.service.InventoryItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "inventory-items")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inventory-items")
public class InventoryItemController {
    private final InventoryItemAssembler inventoryItemAssembler;
    private final InventoryItemService inventoryItemService;

    @GetMapping("/{inventoryItemId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryItemDto get(@PathVariable UUID inventoryItemId) {
        return inventoryItemAssembler.toInventoryItemDto(inventoryItemService.get(inventoryItemId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemDto create(@RequestBody @Valid InventoryItemRequestDto request) {
        return inventoryItemAssembler.toInventoryItemDto(inventoryItemService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<InventoryItemDto> getAll(Pageable pageable) {
        return inventoryItemService.getAll(pageable).map(inventoryItemAssembler::toInventoryItemDto);
    }

    @PutMapping("/{inventoryItemId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryItemDto update(@PathVariable("inventoryItemId") UUID inventoryItemId,
                                   @RequestBody InventoryItemRequestDto inventoryItemRequestDto) {
        if (!inventoryItemId.equals(inventoryItemRequestDto.getInventoryItemId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return inventoryItemAssembler.toInventoryItemDto(inventoryItemService.update(inventoryItemRequestDto));
    }

    @DeleteMapping("/{inventoryItemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID inventoryItemId) {
        inventoryItemService.delete(inventoryItemId);
    }
}
