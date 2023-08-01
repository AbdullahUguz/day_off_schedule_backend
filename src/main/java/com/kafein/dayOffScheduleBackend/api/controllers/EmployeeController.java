package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.business.concrete.EmployeeManager;
import com.kafein.dayOffScheduleBackend.dto.EmployeeDto;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/add")
    private ResponseEntity<String> add(@RequestBody Employee employee){
        try{
            this.employeeService.add(employee);
            return new ResponseEntity<>("Employee successfully  added.", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Employee didnt add.", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getAll")
    private List<Employee> getAll(){
        try{
            return  this.employeeService.getAll();
        }catch (Exception e){
            return null;
        }
    }

    @PutMapping("/remainingDayOff/{employeeId}")
    private ResponseEntity<String> updateRemainingDayOff(@PathVariable int employeeId, @RequestBody EmployeeDto employeeDto){
        try{

            this.employeeService.updateRemainingDayOff( Long.valueOf(employeeId),employeeDto.getUsedDayOff());

            return new ResponseEntity<>("Employee remining day off updated successfully .", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Employee remining day off didnt update", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/isEmailExist")
    private ResponseEntity<String> isEmailExist(@RequestBody EmployeeDto employeeDto){
        try{
            if(this.employeeService.isEmailExist(employeeDto.getEmail())){
                return new ResponseEntity<>("true", HttpStatus.OK); // email exist
            }else{
                return new ResponseEntity<>("false", HttpStatus.OK); // email didnt exist
            }
        }catch (Exception e){
            return new ResponseEntity<>("Email control exceptions", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
