package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;

import java.util.List;

public interface DayOffService {
    void create(DayOff dayOff);
   // List<DayOff> getDaysOffByEmployeeId(long employeeId);
    DayOff getById(long dayOffId);
    DayOff addDayOfDetail(long dayOffId, DayOffDetail dayOffDetail);
}
