package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;


public interface DayOffService {
    DayOff getDayOffById(long employeeId);

    void resetRemainingDayOff(long dayOffId);

    DayOff getById(long dayOffId);

    DayOff addDayOfDetail(long dayOffId, DayOffDetail dayOffDetail);
}
