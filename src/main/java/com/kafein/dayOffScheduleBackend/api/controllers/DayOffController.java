package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.DayOffService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/daysOff")
@CrossOrigin(origins="http://localhost:3000")
public class DayOffController {

    private DayOffService dayOffService;

    @Autowired
    public DayOffController(DayOffService dayOffService){
        this.dayOffService=dayOffService;
    }


    @GetMapping("/getDayOff/{employeeId}")
    private DayOff getAll(@PathVariable int employeeId){
        try{
            return  this.dayOffService.getDayOffById(Long.valueOf(employeeId));
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping("/addDayOffDetail/{dayOffId}")
    private ResponseEntity<DayOff> create(@PathVariable int dayOffId,@RequestBody DayOffDetail dayOffDetail){
        try{
            return new ResponseEntity<>(this.dayOffService.addDayOfDetail(Long.valueOf(dayOffId),dayOffDetail), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
