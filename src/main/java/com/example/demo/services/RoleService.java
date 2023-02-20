package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.RoleDTO;

public interface RoleService {

	List<RoleDTO> GetAllRoles();
	RoleDTO FindRoleById(Long id);
	RoleDTO AddRole( RoleDTO role);
	RoleDTO UpdateRole(Long id, RoleDTO role);
	RoleDTO DeleteRole(Long id);
	
}
