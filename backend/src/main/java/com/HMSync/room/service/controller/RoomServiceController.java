package com.HMSync.room.service.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "room_services")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/room-services")
public class RoomServiceController {
}
