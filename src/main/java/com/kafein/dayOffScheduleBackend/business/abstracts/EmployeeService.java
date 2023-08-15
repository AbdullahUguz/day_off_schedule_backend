package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Department;
import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee, long departmenId) throws Exception;

    //    void updateRemainingDayOff(long employeeId, int usedDayOff);
    List<Employee> getAll();

    void deleteEmployeeById(long employeeId);

    void updateEmployee(long emlpoyeeId, Employee employee, long departmentId) throws Exception;
//    void resetResetRemainingDayOff(long employeeId);

}
