package com.sathish.department.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.department.model.request.DepartmentRequest;
import com.sathish.department.model.response.DepartmentResponse;
import com.sathish.department.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/dept") //base url
@AllArgsConstructor
public class DeptController {

	private DepartmentService departmentService;
	
	@GetMapping("dept")
	public String dept() {
		return "RD depet";
	}
	
	@PostMapping
	public ResponseEntity<DepartmentResponse> createDept(@RequestBody DepartmentRequest departmentRequest){
	
		DepartmentResponse departmentResponse= departmentService.createDepartment(departmentRequest);
		
		return new ResponseEntity<DepartmentResponse>(departmentResponse, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{dpt}")
	public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable("dpt") String dpt){
		DepartmentResponse departmentResponse=   departmentService.getDepartmentByDptId(dpt);
		return new ResponseEntity<DepartmentResponse>(departmentResponse, HttpStatus.OK);
	}
}
