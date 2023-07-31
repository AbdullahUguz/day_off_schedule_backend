package com.kafein.dayOffScheduleBackend.repository;

import com.kafein.dayOffScheduleBackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByOrderByIdAsc();
}
