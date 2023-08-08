package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.DayOffService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/days_off")
@CrossOrigin(origins="http://localhost:3000")
public class DayOffController {

    private DayOffService dayOffService;

    @Autowired
    public DayOffController(DayOffService dayOffService){
        this.dayOffService=dayOffService;
    }

//    @PostMapping("/create")
//    private ResponseEntity<String> add(@RequestBody DayOff dayOff){
//        try{
//            this.dayOffService.create(dayOff);
//            return new ResponseEntity<>("Day off successfully  added.", HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>("Day off did not add.", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

}
