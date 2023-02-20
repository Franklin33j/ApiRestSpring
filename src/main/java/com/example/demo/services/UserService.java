package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.UserDTO;

public interface UserService {

	List<UserDTO> GetAllUsers();
	UserDTO FindUserById(Long id);
	UserDTO AddUser(UserDTO user);
	UserDTO UpdateUser(Long id,UserDTO user);
	UserDTO DeleteUser(Long id);
	
}
