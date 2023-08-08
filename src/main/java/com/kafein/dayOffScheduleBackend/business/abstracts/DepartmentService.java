package com.kafein.dayOffScheduleBackend.business.abstracts;

import com.kafein.dayOffScheduleBackend.entities.Department;

public interface DepartmentService {

    Department create(Department department);
    Department getById(long departmentId);
}
