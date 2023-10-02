package com.sathish.employeeservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReq {
	private String ename;
	private String email;
	private String deptCode;
}
