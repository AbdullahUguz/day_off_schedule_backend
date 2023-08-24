package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee, long departmenId) throws Exception;

    List<Employee> getAll();

    void deleteEmployeeById(long employeeId);

    void updateEmployee(long emlpoyeeId, Employee employee, long departmentId) throws Exception;

}
