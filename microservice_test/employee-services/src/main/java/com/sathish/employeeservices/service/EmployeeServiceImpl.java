package com.sathish.employeeservices.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sathish.employeeservices.model.APIResponse;
import com.sathish.employeeservices.model.DepartmentResp;
import com.sathish.employeeservices.model.Employee;
import com.sathish.employeeservices.model.EmployeeReq;
import com.sathish.employeeservices.model.EmployeeResp;
import com.sathish.employeeservices.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper mapper;
	private WebClient webClient;
	private APIClient apiClient; // our interface inplemented

	@Override
	public EmployeeResp createEmployee(EmployeeReq employeeReq) {
		// TODO Auto-generated method stub
		Employee emData = mapper.map(employeeReq, Employee.class);
		Employee savedEmployee = employeeRepository.save(emData);
		return mapper.map(savedEmployee, EmployeeResp.class);
	}

	@Override
	public EmployeeResp getEmpByEid(int id) {
		// TODO Auto-generated method stub
		Employee empData = employeeRepository.findById(id).get();
		return mapper.map(empData, EmployeeResp.class);
	}

	@Override
	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public APIResponse getEmpAndDept(int id) {
		// TODO Auto-generated method stub
		Employee empData = employeeRepository.findById(id).get();

		// by webclient
		DepartmentResp departmentResp = webClient.get().uri("http://localhost:8081/api/dept/" + empData.getDeptCode())
				.retrieve().bodyToMono(DepartmentResp.class).block();

		// DepartmentResp departmentResp=
		// apiClient.getDepartment(empData.getDeptCode());

		System.out.println(empData);
		System.out.println(departmentResp);
		EmployeeResp employeeResp = mapper.map(empData, EmployeeResp.class);

		APIResponse apiResponse = new APIResponse(employeeResp, departmentResp);
		return apiResponse;
	}

	public APIResponse getDefaultDepartment(int empId, Exception exception) {

		Employee empData = employeeRepository.findById(empId).get();

		DepartmentResp departmentResp = new DepartmentResp(900, "mca", "mca1");

		EmployeeResp employeeResp = mapper.map(empData, EmployeeResp.class);

		APIResponse apiResponse = new APIResponse(employeeResp, departmentResp);
		return apiResponse;
	}

}
