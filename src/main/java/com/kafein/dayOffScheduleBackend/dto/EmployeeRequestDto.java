package com.kafein.dayOffScheduleBackend.dto;

import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import lombok.Data;

@Data
public class EmployeeRequestDto {
    private Employee employee;
    private Integer departmentId;
}
