package com.prodemy.springmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);

}
