package com.sathish.employeeservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathish.employeeservices.model.DepartmentResp;

//@FeignClient(url = "http://localhost:8081/",name = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("api/dept/{deptCode}")
	DepartmentResp getDepartment(@PathVariable("deptCode") String deptCode);
}
