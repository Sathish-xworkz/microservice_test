package com.sathish.employeeservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
	private EmployeeResp employeeResp;
	private DepartmentResp departmentResp;
}
