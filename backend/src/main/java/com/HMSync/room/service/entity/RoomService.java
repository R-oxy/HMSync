package com.HMSync.room.service.entity;

import com.HMSync.catalog.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "room_service_menu")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class RoomService extends BaseEntity {
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "customizations")
    private String customizations;
}
