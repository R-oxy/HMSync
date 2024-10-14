package com.HMSync.housekeeping.repository;

import com.HMSync.housekeeping.entity.HouseKeeping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HouseKeepingRepository extends JpaRepository<HouseKeeping, UUID> {
}
