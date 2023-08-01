package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);
    void updateRemainingDayOff(long employeeId, int usedDayOff);
    List<Employee> getAll();
    boolean isEmailExist(String email);

}
