package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.DepartmentService;
import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.dto.EmployeeRequestDto;
import com.kafein.dayOffScheduleBackend.entities.Department;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    private ResponseEntity<String> create(@RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            this.employeeService.create(employeeRequestDto.getEmployee(), Long.valueOf(employeeRequestDto.getDepartmentId()));

            return new ResponseEntity<>("Employee created", HttpStatus.CREATED);

        } catch (Exception e) {
            String errorMessage;
            if (e.getMessage().contains("email") && e.getMessage().contains("already exists")) {
                errorMessage = "Email already exists";
                return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
            } else {
                errorMessage = "An error occurred while creating employee";
                return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/update/{employeeId}")
    private ResponseEntity<String> update(@PathVariable int employeeId, @RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            this.employeeService.updateEmployee(Long.valueOf(employeeId), employeeRequestDto.getEmployee(), employeeRequestDto.getDepartmentId());
            return new ResponseEntity<>("Employee updated", HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage;
            if (e.getMessage().contains("email") && e.getMessage().contains("already exists")) {
                errorMessage = "Email already exists";
                return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
            } else {
                errorMessage = "An error occurred while creating employee";
                return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/getAll")
    private List<Employee> getAll() {
        try {
            return this.employeeService.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    private ResponseEntity<String> delete(@PathVariable int employeeId) {
        try {
            this.employeeService.deleteEmployeeById(Long.valueOf(employeeId));
            return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Employee delete exception", HttpStatus.EXPECTATION_FAILED);
        }
    }


//    @PutMapping("/remainingDayOff/{employeeId}")
//    private ResponseEntity<String> updateRemainingDayOff(@PathVariable int employeeId, @RequestBody EmployeeDto employeeDto){
//        try{
//
//            this.employeeService.updateRemainingDayOff( Long.valueOf(employeeId),employeeDto.getUsedDayOff());
//
//            return new ResponseEntity<>("Employee remining day off updated successfully .", HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>("Employee remining day off didnt update: "+e, HttpStatus.EXPECTATION_FAILED);
//        }
//    }


//    @PostMapping("/resetRemainingDayOff/{employeeId}")
//    private ResponseEntity<String> resetRemaningDayOff(@PathVariable int employeeId){
//        try{
//            this.employeeService.resetResetRemainingDayOff(Long.valueOf(employeeId));
//
//            return new ResponseEntity<>("Employee updated",HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>("Employee update exception: "+e,HttpStatus.EXPECTATION_FAILED);
//        }
//    }
}
