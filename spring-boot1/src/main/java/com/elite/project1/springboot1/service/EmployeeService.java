package com.elite.project1.springboot1.service;

import com.elite.project1.springboot1.exceptionHandling.EmployeeNotFoundException;
import com.elite.project1.springboot1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService{

    List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        if(employee.getEmpId().isEmpty() ||  null == employee.getEmpId())
        {
            employee.setEmpId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
      /*  return employeeList.stream().filter(
                employee -> employee.getEmpId().equals(id)
        ).findAny().orElseThrow(() ->
                new RuntimeException("Employee details not found with Id "+id)
        );*/


        return employeeList.stream().filter(
                employee -> employee.getEmpId().equals(id)
        ).findAny().orElseThrow(() ->new EmployeeNotFoundException("empoyee not found with given id "+id)
        );
    }

    @Override
    public Employee deleteEmployeeById(String id) {
        Employee employee = employeeList.stream().filter(
                e -> e.getEmpId().equalsIgnoreCase(id)
        ).findFirst().get();

        employeeList.remove(employee);
        return employee;
    }
}
