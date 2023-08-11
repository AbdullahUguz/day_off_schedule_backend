package com.kafein.dayOffScheduleBackend.repository;

import com.kafein.dayOffScheduleBackend.entities.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayOffRepository extends JpaRepository<DayOff,Long> {
//    List<DayOff> findAllByEmployeeId(long employeeId);
}
