package com.elite.project1.springboot1.service;

import com.elite.project1.springboot1.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployeeDetails(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    Employee deleteEmployeeById(String id);
}
