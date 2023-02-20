package com.example.demo.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByUsername(username);
		if (user==null)
		{
			throw new ResourceNotFoundException("email", username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), GetRoles(user.getRoles()));
	}
	
	//metodo para leer los roles
	public Collection<? extends GrantedAuthority > GetRoles(Set<Role> roles)
	{
		return roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
