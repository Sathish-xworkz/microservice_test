package com.sathish.department.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.department.model.Department;
import com.sathish.department.model.request.DepartmentRequest;
import com.sathish.department.model.response.DepartmentResponse;
import com.sathish.department.repository.DepartmentRepository;
import com.sathish.department.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	private ModelMapper modelMapper;
	
	@Override
	public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
		// TODO Auto-generated method stub
		Department saveDepartment=modelMapper.map(departmentRequest, Department.class);
		Department saveDepartmentObj= departmentRepository.save(saveDepartment);
		return modelMapper.map(saveDepartmentObj, DepartmentResponse.class);
	}

	@Override
	public DepartmentResponse getDepartmentByDptId(String dptcode) {
		// TODO Auto-generated method stub
		System.out.println(dptcode);
		Department department= departmentRepository.findByDeptCode(dptcode);
		System.out.println(department);
		return modelMapper.map(department, DepartmentResponse.class);
	}

}
