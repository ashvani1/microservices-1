package com.elite.project1.springboot1.service;

import com.elite.project1.springboot1.entitty.EmployeeEntity;
import com.elite.project1.springboot1.model.Employee;
import com.elite.project1.springboot1.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceV2 implements IEmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        if(employee.getEmpId().isEmpty() ||  null == employee.getEmpId())
        {
            employee.setEmpId(UUID.randomUUID().toString());
        }

        //we need a mapper to convert Employee to EmployeeEntity
        //EmployeeEntity employeeEntity = getMappingForEmployee(employee);
        //As there is no logic involve in mapping so instead of doing mapping as below, we will be using BeanUtils

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepo.save(employeeEntity);
        return employee;
    }

    private EmployeeEntity getMappingForEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setDepartment(employee.getDepartment());
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmpId(employee.getEmpId());
        return employeeEntity;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeEntityList) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<EmployeeEntity> o = employeeRepo.findById(id);
        Employee employee = new Employee();

        if(!ObjectUtils.isEmpty(o))
        {
            EmployeeEntity employeeEntity = o.get();
            BeanUtils.copyProperties(employeeEntity, employee);
        }
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(String id) {
        //below  call is overhead on DB and has to be removed as part of refactoring
        Employee e = new Employee();
        BeanUtils.copyProperties(employeeRepo.findById(id), e);
        employeeRepo.deleteById(id);
        return e;
    }
}
