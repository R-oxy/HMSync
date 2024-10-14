package com.HMSync.housekeeping.service;

import com.HMSync.housekeeping.controller.assembler.HouseKeepingAssembler;
import com.HMSync.housekeeping.controller.dto.HouseKeepingRequestDto;
import com.HMSync.housekeeping.entity.HouseKeeping;
import com.HMSync.housekeeping.repository.HouseKeepingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HouseKeepingServiceImpl implements HouseKeepingService{
    private final HouseKeepingRepository houseKeepingRepository;
    private final HouseKeepingAssembler houseKeepingAssembler;

    @Override
    public HouseKeeping create(HouseKeepingRequestDto houseKeepingRequestDto) {
        HouseKeeping houseKeeping = new HouseKeeping();

        return Optional.of(houseKeeping)
                .map(entity -> houseKeepingAssembler.toHouseKeeping(houseKeepingRequestDto, entity))
                .map(houseKeepingRepository::save)
                .orElseThrow(() -> new RuntimeException("HouseKeeping was not saved"));
    }

    @Override
    public Page<HouseKeeping> getAll(Pageable pageable) {
        return houseKeepingRepository.findAll(pageable);
    }

    @Override
    public HouseKeeping update(HouseKeepingRequestDto houseKeepingRequestDto) {
        HouseKeeping houseKeeping = get(houseKeepingRequestDto.getHouseKeepingId());
        try {
            return houseKeepingRepository.save(houseKeepingAssembler.toHouseKeeping(houseKeepingRequestDto, houseKeeping));
        } catch (Exception e) {
            log.error("Error updating housekeeping record: {}", e.getMessage(), e);
            throw new RuntimeException("HouseKeeping was not updated due to an unexpected error");
        }
    }

    @Override
    public HouseKeeping get(UUID houseKeepingId) {
        return Optional.of(houseKeepingId)
                .flatMap(houseKeepingRepository::findById)
                .orElseThrow(() -> new RuntimeException("HouseKeeping with ID: " + houseKeepingId + " does not exist"));
    }

    @Override
    public void delete(UUID houseKeepingId) {
        get(houseKeepingId);
        houseKeepingRepository.deleteById(houseKeepingId);
    }
}
