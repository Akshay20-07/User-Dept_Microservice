package com.nullcheck.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nullcheck.userservice.entity.User;
import com.nullcheck.userservice.repo.UserRepository;
import com.nullcheck.userservice.valueobject.Department;
import com.nullcheck.userservice.valueobject.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemp;

	public User saveUser(User user) {
		log.info("save user in User Service");
		return userRepo.save(user);
	}

	public ResponseTemplateVO findById(Long id) {

		log.info("find user by id: {} ", id, "in User Service");
		
		User user = userRepo.findByUserId(id);

		Department dept = restTemp.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		
		ResponseTemplateVO respVO = new ResponseTemplateVO(user,dept);
		return respVO;

	}
}
