package com.elite.project1.springboot1.repository;

import com.elite.project1.springboot1.entitty.EmployeeEntity;
import com.elite.project1.springboot1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
}
