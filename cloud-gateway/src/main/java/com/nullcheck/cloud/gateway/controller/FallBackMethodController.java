package com.nullcheck.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userSVCFallBack() {
		return "User service is taking longer than expected";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentSVCFallBack() {
		return "Department service is taking longer than expected";
	}
}
