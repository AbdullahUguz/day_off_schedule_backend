package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.DayOffService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.repository.DayOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
