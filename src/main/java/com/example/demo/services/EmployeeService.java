package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.EmployeeDTO;


public interface EmployeeService {
	
	List<EmployeeDTO> GetAllEmployees();
	EmployeeDTO FindEmployeeByDni(String dni);
	EmployeeDTO AddEmployee(String usernameOrEmail, String dniSale);
	EmployeeDTO UpdateEmployee(String usernameOrEmail, String dniSale, String dniEmployee);
	EmployeeDTO DeleteEmployee(String dni);

}
