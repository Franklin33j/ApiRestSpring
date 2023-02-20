package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.EmployeeDTO;


public interface EmployeeService {
	
	List<EmployeeDTO> GetAllEmployees();
	EmployeeDTO FindEmployeeById(Long id);
	EmployeeDTO AddEmployee(EmployeeDTO employee);
	EmployeeDTO UpdateEmployee(Long id, EmployeeDTO employee);
	EmployeeDTO DeleteEmployee(Long id);

}
