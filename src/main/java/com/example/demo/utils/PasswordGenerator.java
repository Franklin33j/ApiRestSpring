package com.example.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("password"));

	}

}
