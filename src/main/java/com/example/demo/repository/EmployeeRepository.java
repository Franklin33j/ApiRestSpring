package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employee;
import com.example.demo.models.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByDni(String dni);

	Employee findByUser(User user);
	

}
