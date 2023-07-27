package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import com.kafein.dayOffScheduleBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public void add(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }
}
