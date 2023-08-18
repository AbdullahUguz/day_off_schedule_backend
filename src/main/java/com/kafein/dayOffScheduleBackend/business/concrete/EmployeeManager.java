package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.entities.DayOff;
import com.kafein.dayOffScheduleBackend.entities.Department;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import com.kafein.dayOffScheduleBackend.repository.DepartmentRepository;
import com.kafein.dayOffScheduleBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Value("${custom.dayOff.initialValue}")
    private int initialDayOff;
    @Value("${custom.dayOff.remainingDayOffValue}")
    private float remainingDayOff;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository){
        this.employeeRepository=employeeRepository;
        this.departmentRepository=departmentRepository;
    }

    @Override
    public void create(Employee employee,long departmenId) throws Exception{
        try{
            DayOff dayOff = new DayOff();
            Department department = this.departmentRepository.findById(departmenId).get();

            dayOff.setInitialDayOff(initialDayOff);
            dayOff.setRemainingDayOff(remainingDayOff);
            employee.setDayOff(dayOff);
            employee.setDepartment(department);
            this.employeeRepository.save(employee);

        }catch (Exception e){
            throw new Exception(e);

        }
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAllByIsVisibleTrueOrderByIdAsc();
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        Employee employeCntrl = this.employeeRepository.findById(employeeId).get();
        employeCntrl.setIsVisible(false);
        this.employeeRepository.save(employeCntrl);
    }

    @Override
    public void updateEmployee(long employeeId, Employee employee, long departmentId) throws Exception {
        try {
            Department departmentCntrl = this.departmentRepository.findById(departmentId).get();
            Employee employeeCntrl = this.employeeRepository.findById(employeeId).get();

            if(employeeCntrl.getDepartment().getId() != departmentId){
                employeeCntrl.setDepartment(employee.getDepartment());
            }

            employeeCntrl.setName(employee.getName());
            employeeCntrl.setLastName(employee.getLastName());
            employeeCntrl.setEmail(employee.getEmail());
            employeeCntrl.setDepartment(departmentCntrl);
            this.employeeRepository.save(employeeCntrl);
        }catch (Exception e){
             throw new Exception(e);
        }
    }

}
