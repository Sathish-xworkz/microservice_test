package com.sathish.employeeservices.service;

import com.sathish.employeeservices.model.APIResponse;
import com.sathish.employeeservices.model.EmployeeReq;
import com.sathish.employeeservices.model.EmployeeResp;

public interface EmployeeService {

	EmployeeResp  createEmployee(EmployeeReq employeeReq);
	
	EmployeeResp getEmpByEid(int id);
	
	APIResponse getEmpAndDept(int id);
}
