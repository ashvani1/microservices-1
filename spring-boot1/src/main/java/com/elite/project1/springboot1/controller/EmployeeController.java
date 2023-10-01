package com.elite.project1.springboot1.controller;

import com.elite.project1.springboot1.model.Employee;
import com.elite.project1.springboot1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

    @Autowired //this is work if only 1 implementation is defined
    private IEmployeeService employeeService;

    @PostMapping("/")
    public Employee save (@RequestBody Employee employee) {
       return employeeService.saveEmployeeDetails(employee);
    }

    @GetMapping
    public List<Employee> get(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/doCalculation")
    public int toThroughGenericException() {
        return  1/0;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
