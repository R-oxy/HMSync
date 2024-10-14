package com.HMSync.housekeeping.controller.dto;

import com.HMSync.rooms.controller.dto.RoomDto;
import com.HMSync.staff.controller.dto.StaffDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class HouseKeepingDto {
    private UUID houseKeepingId;
    private RoomDto room;
    private String roomStatus;
    private LocalDate cleaningSchedule;
    private StaffDto houseKeeperAssigned;
}
