package com.sathish.employeeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.employeeservices.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
