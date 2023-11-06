package com.prodemy.springmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
	
}
