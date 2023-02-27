package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserDTO;
import com.example.demo.services.UserService;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("api/admin/users")
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<List<UserDTO>> GetAllUsers()
	{
		
	return ResponseEntity.ok(userService.GetAllUsers()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> FindUserById(@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(userService.FindUserById(id));
	}
	@PostMapping
	public ResponseEntity<UserDTO> AddUser (@Valid @RequestBody UserDTO user)
	{
		return ResponseEntity.ok(userService.AddUser(user));
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> UpdateUser(
			@Valid @RequestBody UserDTO user,
			@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(userService.UpdateUser(id, user));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> DeleteUser(@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(userService.DeleteUser(id));
	}
}
