package com.HMSync.inventory.management.repository;

import com.HMSync.inventory.management.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {
}
