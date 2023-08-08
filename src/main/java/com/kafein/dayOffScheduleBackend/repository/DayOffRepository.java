package com.kafein.dayOffScheduleBackend.repository;

import com.kafein.dayOffScheduleBackend.entities.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayOffRepository extends JpaRepository<DayOff,Long> {
}
