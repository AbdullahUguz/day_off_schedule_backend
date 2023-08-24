package com.kafein.dayOffScheduleBackend.api.controllers;

import com.kafein.dayOffScheduleBackend.business.abstracts.DepartmentService;
import com.kafein.dayOffScheduleBackend.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    private ResponseEntity<Department> create(@RequestBody Department department) {
        try {
            return new ResponseEntity<>(this.departmentService.create(department), HttpStatus.CREATED);
        } catch (Exception e) {
            if (e.getMessage().contains("already exists") && e.getMessage().contains("name")) {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getAll")
    private List<Department> getAll() {
        try {
            return this.departmentService.getAll();
        } catch (Exception e) {
            return null;
        }
    }
}
