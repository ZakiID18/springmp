package com.prodemy.springmp.service;

import java.util.List;
import java.util.Optional;

import com.prodemy.springmp.dto.UserDto;
import com.prodemy.springmp.model.User;

public interface UserService {
	
	void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
    Optional<User> getUserById(Long id);
    void deleteUserById(Long id);

}
