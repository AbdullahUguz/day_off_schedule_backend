package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Department;
import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);
//    void updateRemainingDayOff(long employeeId, int usedDayOff);
    List<Employee> getAll();
    void deleteEmployeeById(long employeeId);
    void updateEmployee(long emlpoyeeId, Employee employee, Department department) throws Exception;
//    void resetResetRemainingDayOff(long employeeId);

}
