package com.sathish.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.department.model.Department;
import com.sathish.department.model.response.DepartmentResponse;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	Department findByDeptCode(String deptCode);

}
