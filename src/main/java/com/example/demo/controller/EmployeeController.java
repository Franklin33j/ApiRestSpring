package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.RegisterEmployeeDTO;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/api/admin/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>>GetAllEmployees(){
		
		return ResponseEntity.ok(employeeService.GetAllEmployees());
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{dni}")
	public ResponseEntity<EmployeeDTO>FindEmployeeByDni(@PathVariable(name = "dni") String dni){
		
		return ResponseEntity.ok(employeeService.FindEmployeeByDni(dni));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<EmployeeDTO> AddEmployeer(@Valid @RequestBody RegisterEmployeeDTO data ){
	
		return ResponseEntity.ok(employeeService.AddEmployee(data.getUsernameOrEmail(), data.getDniSale()));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{dniEmployee}")
	public ResponseEntity<EmployeeDTO> UpdateEmployee(@PathVariable(name = "dniEmployee") String dniEmployee, 
			@Valid @RequestBody RegisterEmployeeDTO data  )
	{
		return ResponseEntity.ok(employeeService.UpdateEmployee(data.getUsernameOrEmail(), data.getDniSale(), dniEmployee));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{dni}")
	public ResponseEntity<EmployeeDTO> DeleteEmployee(@PathVariable(name = "dni") String dni  )
	{
		return ResponseEntity.ok(employeeService.DeleteEmployee(dni));
	}
}
