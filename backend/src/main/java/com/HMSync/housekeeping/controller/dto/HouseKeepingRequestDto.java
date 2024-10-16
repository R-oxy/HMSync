package com.HMSync.housekeeping.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class HouseKeepingRequestDto {
    private UUID houseKeepingId;

    @NotNull(message = "Room ID is required")
    private UUID roomId;

    @NotBlank(message = "Room status is required")
    private String roomStatus;

    @NotNull(message = "Cleaning schedule is required")
    private LocalDate cleaningSchedule;

    @NotNull(message = "Housekeeper ID is required")
    private UUID houseKeeperId;
}
