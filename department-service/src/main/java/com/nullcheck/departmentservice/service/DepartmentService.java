package com.nullcheck.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nullcheck.departmentservice.entity.Department;
import com.nullcheck.departmentservice.repo.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	public Department save(Department dept) {
		log.info("save department in department Service");
		return departmentRepo.save(dept);
	}

	public Department getDepartmentById(Long id) {
		log.info("find by id in department service");
		return departmentRepo.findByDepartmentId(id);
	}
}
