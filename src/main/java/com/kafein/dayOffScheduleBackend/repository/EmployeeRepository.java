package com.kafein.dayOffScheduleBackend.repository;

import com.kafein.dayOffScheduleBackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
