package com.HMSync.room.service.controller.assembler;

import com.HMSync.room.service.controller.dto.RoomServiceDto;
import com.HMSync.room.service.controller.dto.RoomServiceRequestDto;
import com.HMSync.room.service.entity.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomServiceAssembler {
    public RoomServiceDto toRoomServiceDto(RoomService from) {
        RoomServiceDto to = new RoomServiceDto();
        to.setServiceId(from.getId());
        to.setItemName(from.getItemName());
        to.setItemCategory(from.getItemCategory());
        to.setPrice(from.getPrice());
        to.setAvailability(from.isAvailability());
        to.setCustomizations(from.getCustomizations());
        return to;
    }

    public RoomService toRoomService(RoomServiceRequestDto from, RoomService to) {
        to.setId(from.getServiceId());
        to.setItemName(from.getItemName());
        to.setItemCategory(from.getItemCategory());
        to.setPrice(from.getPrice());
        to.setAvailability(from.isAvailability());
        to.setCustomizations(from.getCustomizations());
        return to;
    }
}
