package com.nullcheck.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nullcheck.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>  {

	User findByUserId(Long id);

}
