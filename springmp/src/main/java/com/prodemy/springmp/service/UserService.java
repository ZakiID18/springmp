package com.prodemy.springmp.service;

import java.util.List;

import com.prodemy.springmp.dto.UserDto;
import com.prodemy.springmp.model.User;

public interface UserService {
	
	void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();

}
