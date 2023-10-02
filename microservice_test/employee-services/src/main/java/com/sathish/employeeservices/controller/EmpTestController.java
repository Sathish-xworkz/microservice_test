package com.sathish.employeeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmpTestController {
//@Autowired
	private WebClient webClient;

	@GetMapping("/emp")
	public String emp() {

		String dept = webClient.get().uri("http://localhost:8081/api/dept").retrieve().bodyToMono(String.class).block();

		return " Sathish working with:" + dept;
	}
}
