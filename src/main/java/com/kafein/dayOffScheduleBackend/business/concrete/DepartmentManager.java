package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.DepartmentService;
import com.kafein.dayOffScheduleBackend.entities.Department;
import com.kafein.dayOffScheduleBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department getById(long departmentId) {
        return this.departmentRepository.findById(departmentId).get();
    }

    @Override
    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }
}
