package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.DayOffService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;
import com.kafein.dayOffScheduleBackend.repository.DayOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOffManager implements DayOffService {
    private DayOffRepository dayOffRepository;

    @Autowired
    public DayOffManager(DayOffRepository dayOffRepository){
        this.dayOffRepository=dayOffRepository;
    }

    @Override
    public void create(DayOff dayOff) {
        this.dayOffRepository.save(dayOff);
    }

//    @Override
//    public List<DayOff> getDaysOffByEmployeeId(long employeeId) {
//        return this.dayOffRepository.findAllByEmployeeId(employeeId);
//    }

    @Override
    public DayOff getById(long dayOffId) {
        return this.dayOffRepository.findById(dayOffId).get();
    }

    @Override
    public DayOff addDayOfDetail(long dayOffId, DayOffDetail dayOffDetail) {
        DayOff dayOff = this.getById(dayOffId);
        dayOff.getDayOffDetailList().add(dayOffDetail);
        return this.dayOffRepository.save(dayOff);
    }
}
