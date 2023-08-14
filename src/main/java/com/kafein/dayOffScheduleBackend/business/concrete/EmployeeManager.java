package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.entities.Department;
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
    public void create(Employee employee) {
         this.employeeRepository.save(employee);
    }

//    @Override
//    public void updateRemainingDayOff(long employeeId, int usedDayOff) {
//
//        try {
//            Optional<Employee> employee= this.employeeRepository.findById(employeeId);
//            employee.get().setRemainingDayOff(employee.get().getRemainingDayOff() - usedDayOff);
//
//            this.employeeRepository.save(employee.get());
//
//        }catch (Exception e){
//            new Throwable("update remining dayy off exceptions");
//        }
//    }

    @Override
    public List<Employee> getAll() {
       // return this.employeeRepository.findAllByOrderByIdAsc();
        return this.employeeRepository.findAllByIsVisibleTrueOrderByIdAsc();
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        Employee employeCntrl = this.employeeRepository.findById(employeeId).get();
        employeCntrl.setIsVisible(false);
        this.employeeRepository.save(employeCntrl);
    }

    @Override
    public void updateEmployee(long employeeId, Employee employee, Department department) throws Exception {
        try {
            Employee employeeCntrl = this.employeeRepository.findById(employeeId).get();

            if(employeeCntrl.getDepartment().getId() != department.getId()){
                employeeCntrl.setDepartment(employee.getDepartment());
            }

            employeeCntrl.setName(employee.getName());
            employeeCntrl.setLastName(employee.getLastName());
            employeeCntrl.setEmail(employee.getEmail());
            employeeCntrl.setDepartment(department);
            this.employeeRepository.save(employeeCntrl);
        }catch (Exception e){
             throw new Exception(e);
        }
    }

//    @Override
//    public void resetResetRemainingDayOff(long employeeId) {
//        try {
//
//            Employee employeeCntrl = this.employeeRepository.findById(employeeId).get();
//            employeeCntrl.setRemainingDayOff(employeeCntrl.getDayOff());
//            this.employeeRepository.save(employeeCntrl);
//
//        }catch (Exception e){
//            new Throwable("reset remaining day off exception : "+e);
//        }
//    }
}
