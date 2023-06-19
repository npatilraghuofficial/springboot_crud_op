package com.springboot.first.app.service;

import com.springboot.first.app.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Iterable<Employee> getAllEmployees();

    Employee getEmployeeById(long id);  
    Employee updateEmployee(Employee employee);

    void deleteEmployee(long id);


}
