package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	User findByUsername(String username);
	Optional<User> findByUsernameOrEmail(String username, String email);

}
