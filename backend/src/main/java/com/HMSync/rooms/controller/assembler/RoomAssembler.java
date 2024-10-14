package com.HMSync.rooms.controller.assembler;

import com.HMSync.rooms.controller.dto.RoomDto;
import com.HMSync.rooms.controller.dto.RoomRequestDto;
import com.HMSync.rooms.entity.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomAssembler {
    public RoomDto toRoomDto(Room from) {
        RoomDto to = new RoomDto();
        to.setRoomId(from.getId());
        to.setRoomNumber(from.getRoomNumber());
        to.setRoomCategory(from.getRoomCategory());
        to.setRoomType(from.getRoomType());
        to.setFloorNumber(from.getFloorNumber());
        to.setNumberOfBeds(from.getNumberOfBeds());
        to.setRoomAmenities(from.getRoomAmenities());
        to.setSpecialFeatures(from.getSpecialFeatures());
        to.setOccupancyStatus(from.getOccupancyStatus());
        return to;
    }

    public Room toRoom(RoomRequestDto from, Room to) {
        to.setId(from.getRoomId());
        to.setRoomNumber(from.getRoomNumber());
        to.setRoomCategory(from.getRoomCategory());
        to.setRoomType(from.getRoomType());
        to.setFloorNumber(from.getFloorNumber());
        to.setNumberOfBeds(from.getNumberOfBeds());
        to.setRoomAmenities(from.getRoomAmenities());
        to.setSpecialFeatures(from.getSpecialFeatures());
        to.setOccupancyStatus(from.getOccupancyStatus());
        return to;
    }
}
