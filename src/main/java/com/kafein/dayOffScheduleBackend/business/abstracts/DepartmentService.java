package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department);
    Department getById(long departmentId);
    List<Department> getAll();
}
