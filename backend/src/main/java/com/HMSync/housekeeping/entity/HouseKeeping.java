package com.HMSync.housekeeping.entity;

import com.HMSync.catalog.entity.BaseEntity;
import com.HMSync.rooms.entity.Room;
import com.HMSync.staff.entity.Staff;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "housekeeping")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class HouseKeeping extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "room_status")
    private String roomStatus;

    @Column(name = "cleaning_schedule")
    private LocalDate cleaningSchedule;

    @ManyToOne
    @JoinColumn(name = "housekeeper_id", referencedColumnName = "id")
    private Staff houseKeeperAssigned;
}
