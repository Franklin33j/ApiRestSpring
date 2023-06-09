package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.JwtAuthResponseDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AuthService authService;
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponseDTO> login(@Valid @RequestBody LoginDTO data){
		
		
		//iniciar sesion
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
	 String token = jwtTokenProvider.generateToken(authentication);
	
	return ResponseEntity.ok(new JwtAuthResponseDTO(token));
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO data)
	{
		return ResponseEntity.ok(authService.RegisterUser(data));
	}

}
