package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RoleDTO;
import com.example.demo.services.RoleService;

@RestController
@RequestMapping("/api/roles")

public class RoleController {

	@Autowired
	RoleService roleService;
	@GetMapping
	public ResponseEntity<List<RoleDTO>> GetAllRoles()
	{
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();*/
		return ResponseEntity.ok(roleService.GetAllRoles());
	}
	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> FindRoleById(@PathVariable (name = "id") long id)
	{
		return ResponseEntity.ok(roleService.FindRoleById(id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<RoleDTO> AddRole(
			@Valid @RequestBody RoleDTO role)
	{
		
		return ResponseEntity.ok(roleService.AddRole(role));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<RoleDTO> UpdateRole(
			@PathVariable(name = "id")long id,
			@Valid @RequestBody RoleDTO role )
	{
		return ResponseEntity.ok(roleService.UpdateRole(id, role));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<RoleDTO> DeleteRole(@PathVariable(name = "id") long id)
	{
		return ResponseEntity.ok(roleService.DeleteRole(id));
	}
}
