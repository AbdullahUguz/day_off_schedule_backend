package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department create(Department department);

    List<Department> getAll();
}
