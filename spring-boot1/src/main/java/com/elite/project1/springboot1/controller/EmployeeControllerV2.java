package com.elite.project1.springboot1.controller;

import com.elite.project1.springboot1.model.Employee;
import com.elite.project1.springboot1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeControllerV2 {
    @Autowired
    @Qualifier("employeeServiceV2")
    private IEmployeeService employeeService;


    @PostMapping("/")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployeeDetails(employee);
    }

    @GetMapping("/")
    public List<Employee> get(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

}
