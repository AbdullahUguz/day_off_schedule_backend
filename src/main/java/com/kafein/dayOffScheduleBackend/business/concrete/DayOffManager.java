package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.DayOffService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;
import com.kafein.dayOffScheduleBackend.repository.DayOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DayOffManager implements DayOffService {
    private DayOffRepository dayOffRepository;

    @Value("${custom.dayOff.remainingDayOffValue}")
    private float remainingDayOff;

    @Autowired
    public DayOffManager(DayOffRepository dayOffRepository) {
        this.dayOffRepository = dayOffRepository;
    }


    @Override
    public DayOff getDayOffById(long employeeId) {
        return this.dayOffRepository.findById(employeeId).get();
    }

    @Override
    public void resetRemainingDayOff(long dayOffId) {
        try {

            DayOff dayOffCntrl = this.dayOffRepository.findById(dayOffId).get();
            dayOffCntrl.setRemainingDayOff(remainingDayOff);
            this.dayOffRepository.save(dayOffCntrl);

        } catch (Exception e) {
            new Throwable("reset remaining day off exception : " + e);
        }
    }

    @Override
    public DayOff getById(long dayOffId) {
        return this.dayOffRepository.findById(dayOffId).get();
    }

    @Override
    public DayOff addDayOfDetail(long dayOffId, DayOffDetail dayOffDetail) {
        DayOff dayOff = this.getById(dayOffId);
        dayOff.setRemainingDayOff(dayOff.getRemainingDayOff() - dayOffDetail.getUsedDayOff());
        dayOffDetail.setDayOff(dayOff);
        dayOff.getDayOffDetailList().add(dayOffDetail);

        return this.dayOffRepository.save(dayOff);
    }
}
