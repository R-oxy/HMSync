package com.HMSync.inventory.management.entity;

import com.HMSync.catalog.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "inventory_items")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class InventoryItem extends BaseEntity {
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Column(name = "quantity_available")
    private int quantityAvailable;
}
