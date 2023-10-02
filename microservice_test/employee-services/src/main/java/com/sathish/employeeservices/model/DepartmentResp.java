package com.sathish.employeeservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResp {
	private int id;
	private String deptName;
	private String deptCode;
}