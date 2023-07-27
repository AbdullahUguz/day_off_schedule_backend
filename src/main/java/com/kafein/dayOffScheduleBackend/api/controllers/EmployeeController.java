package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
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

}
