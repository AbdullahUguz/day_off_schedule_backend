package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);
//    void updateRemainingDayOff(long employeeId, int usedDayOff);
    List<Employee> getAll();
    boolean isEmailExist(String email);
    void deleteEmployeeById(long employeeId);
//    void updateEmployee(long emlpoyeeId,Employee employee);
//    void resetResetRemainingDayOff(long employeeId);
}
