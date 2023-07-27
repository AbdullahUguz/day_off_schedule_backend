package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);
    List<Employee> getAll();
}
