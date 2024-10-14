package com.HMSync.housekeeping.controller.assembler;

import com.HMSync.housekeeping.controller.dto.HouseKeepingDto;
import com.HMSync.housekeeping.controller.dto.HouseKeepingRequestDto;
import com.HMSync.housekeeping.entity.HouseKeeping;
import com.HMSync.rooms.controller.assembler.RoomAssembler;
import com.HMSync.rooms.entity.Room;
import com.HMSync.rooms.service.RoomService;
import com.HMSync.staff.controller.assembler.StaffAssembler;
import com.HMSync.staff.entity.Staff;
import com.HMSync.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HouseKeepingAssembler {
    private final RoomService roomService;
    private final StaffService staffService;
    private final RoomAssembler roomAssembler;
    private final StaffAssembler staffAssembler;

    public HouseKeepingDto toHouseKeepingDto(HouseKeeping from) {
        HouseKeepingDto to = new HouseKeepingDto()
                .setHouseKeepingId(from.getId())
                .setRoomStatus(from.getRoomStatus())
                .setCleaningSchedule(from.getCleaningSchedule());

        if (from.getRoom() != null) {
            to.setRoom(roomAssembler.toRoomDto(from.getRoom()));
        }

        if (from.getHouseKeeperAssigned() != null) {
            to.setHouseKeeperAssigned(staffAssembler.toStaffDto(from.getHouseKeeperAssigned()));
        }

        return to;
    }

    public HouseKeeping toHouseKeeping(HouseKeepingRequestDto from, HouseKeeping to) {
        Room room = roomService.get(from.getRoomId());
        Staff houseKeeper = staffService.get(from.getHouseKeeperId());

        to.setRoom(room)
                .setRoomStatus(from.getRoomStatus())
                .setCleaningSchedule(from.getCleaningSchedule())
                .setHouseKeeperAssigned(houseKeeper);

        return to;
    }
}
