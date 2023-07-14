package com.springboot.first.app.service.impl;

import com.springboot.first.app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.first.app.model.Employee;
import com.springboot.first.app.repository.EmployeeRepository;
import com.springboot.first.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

private EmployeeRepository employeeRepository;

public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    super();
    this.employeeRepository = employeeRepository;
}



    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }



    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
                        
    }



    @Override
    public Employee getEmployeeById(long id) {
        //
        if(employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id).get();
        }else
        {
            throw new RuntimeException("Employee not found with id "+id);
        }
    }



    @Override
    public Employee updateEmployee(Employee employee) {
       Employee existingEmp = employeeRepository.findById(employee.getId()).get();
       
       existingEmp.setFirstName(employee.getFirstName());
         existingEmp.setLastName(employee.getLastName());
            existingEmp.setEmail(employee.getEmail());
             employeeRepository.save(existingEmp);
             return existingEmp;
        
    }



    @Override
    public void deleteEmployee(long id) {
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
        }else
        {
            throw new ResourceNotFoundException("Employee","id",id);
        }
    }
    
}
