package com.example.demo.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.RoleDTO;
import com.example.demo.DTO.SaleDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SaleRepository;
import com.example.demo.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public List<RoleDTO> GetAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles.stream().map((role) -> mapper.map(role, RoleDTO.class)).collect(Collectors.toList());
	}

	@Override
	public RoleDTO FindRoleById(Long id) {

		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id", Long.toString(id)));
		return mapper.map(role, RoleDTO.class);
	}

	@Override
	public RoleDTO AddRole(RoleDTO role) {

		Role roleVerified = RoleAdded(role);
		return mapper.map(roleVerified, RoleDTO.class);
	}

	@Override
	public RoleDTO UpdateRole(Long id, RoleDTO role) {
		Role roleExist = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id", Long.toString(id)));
		Role roleVerified = RoleUpdated(roleExist, role);
		return mapper.map(roleVerified, RoleDTO.class);
	}

	@Override
	public RoleDTO DeleteRole(Long id) {
		Role roleExist = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id", Long.toString(id)));
		roleRepository.delete(roleExist);
		return mapper.map(roleExist, RoleDTO.class);
	}

	private Role RoleAdded(RoleDTO roleDTO) {
		Role roleStatus = roleRepository.findByName(roleDTO.getName());
		// agregar
		
			if (roleStatus != null) {
				throw new ResourceDuplicatedException("name", roleDTO.getName());
			}
			Role roleCre = new Role();
			roleCre.setName(roleDTO.getName());
			return roleRepository.save(roleCre);
	}

	private Role RoleUpdated(Role role, RoleDTO roleDTO) {
		Role roleStatus = roleRepository.findByName(roleDTO.getName());
		// actualizar
		if (roleStatus != null) {
			if (!roleStatus.getId().equals(role.getId())) {
				throw new ResourceDuplicatedException("name", roleDTO.getName());
			}
		}

		if (!roleDTO.getName().equals(role.getName())) {
			role.setName(roleDTO.getName());
		}
		return roleRepository.save(role);
	}

}
