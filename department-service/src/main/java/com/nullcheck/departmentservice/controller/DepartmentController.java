package com.nullcheck.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nullcheck.departmentservice.entity.Department;
import com.nullcheck.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department dept) {
	
		log.info("save Department in DepartmentController");	
		return departmentService.save(dept);
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id) {
		
		log.info("find by id :{} ",id,"in DepartmentController");
		return departmentService.getDepartmentById(id);
		
	}
}
