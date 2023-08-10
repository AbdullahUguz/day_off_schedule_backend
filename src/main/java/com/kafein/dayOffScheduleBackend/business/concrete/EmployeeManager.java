package com.kafein.dayOffScheduleBackend.business.concrete;

import com.kafein.dayOffScheduleBackend.business.abstracts.EmployeeService;
import com.kafein.dayOffScheduleBackend.entities.Employee;
import com.kafein.dayOffScheduleBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
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
        return this.employeeRepository.findAll();
    }

    @Override
    public boolean isEmailExist(String email) {
        try{
            Employee employee = this.employeeRepository.findByEmail(email);
            if(employee == null){
                return false;
            }else {
                return true;
            }

        }catch (Exception e){
            new Throwable("email control exception : "+e);
        }
        return false;
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }

//    @Override
//    public void updateEmployee(long employeeId,Employee employee) {
//        try {
//            Employee employeeCntrl = this.employeeRepository.findById(employeeId).get();
//
//            employeeCntrl.setName(employee.getName());
//            employeeCntrl.setLastName(employee.getLastName());
//            employeeCntrl.setDepartment(employee.getDepartment());
//            employeeCntrl.setEmail(employee.getEmail());
//            employeeCntrl.setDayOff(employee.getDayOff());
//
//            this.employeeRepository.save(employeeCntrl);
//        }catch (Exception e){
//            new Throwable("employee update exception : "+e);
//        }
//    }
//
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
