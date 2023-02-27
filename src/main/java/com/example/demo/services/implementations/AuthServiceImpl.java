package com.example.demo.services.implementations;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.RegisterDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.AuthService;
@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public String RegisterUser(RegisterDTO data) {
		//por si de alguna manera se asignan
		data.setRoles(null);
		User user = mapper.map(data, User.class);
		try {
			
			Set<Role> roles = new HashSet<>();
				roles.add(roleRepository.findByName("ROLE_USER"));
			data.setRoles(roles);
			userRepository.save(user);
		}catch (Exception e) {
			throw new ResourceDuplicatedException("Username o Email", String.format(" %s o %s",user.getUsername(), user.getEmail() ));
		}
		return "Usuario registrado con exito";
	}

}
