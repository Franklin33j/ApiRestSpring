package com.example.demo.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.models.Sale;
import com.example.demo.models.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ModelMapper mapper;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SaleRepository saleRepository;
	
	@Override
	public List<EmployeeDTO> GetAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeesResponse=new ArrayList<>();
		
		  //no utilice stream.map.collect porque no encontre la manera de ocultar el valor de password
		    for (Employee employee :employees) {
		    
		    	employee.getUser().setPassword("");
		        employeesResponse.add(mapper.map(employee, EmployeeDTO.class));
		    }

		return  employeesResponse;
	}

	@Override
	public EmployeeDTO FindEmployeeByDni(String dni) {
		Employee employee= employeeRepository.findByDni(dni).orElseThrow(()->
			 new ResourceNotFoundException("dni",dni));
		employee.getUser().setPassword("");
		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO AddEmployee(String usernameOrEmail, String dniSale) {
		User user= userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(()->
		new  ResourceNotFoundException("Username o Email", usernameOrEmail));
		
		Employee  findEmployee= employeeRepository.findByUser(user);
		if(findEmployee !=null)
		{
			throw new ResourceDuplicatedException("Username o Email", usernameOrEmail);
		}
		Sale sale = saleRepository.findByDni(dniSale).orElseThrow(()->
		new ResourceNotFoundException("dni de sala", dniSale));
		Random rand = new Random();
        String  randomNumber =Integer.toString( rand.nextInt(9999));
        //buscar si ese dni ya existe
        Employee userExist= employeeRepository.findByDni( randomNumber).orElse(null);
        while(userExist!=null)
        {
        	
            randomNumber =Integer.toString( rand.nextInt(9999));
            userExist= employeeRepository.findByDni( randomNumber).orElse(null);
        }
		Employee employee = new Employee();
		employee.setDni( randomNumber);
		employee.setUser(user);
		employee.setSale(sale);
		Employee employeeSaved= employeeRepository.save(employee);
		return mapper.map(employeeSaved, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO UpdateEmployee(String usernameOrEmail, String dniSale, String dniEmployee) {
		Employee employee=employeeRepository.findByDni(dniEmployee).orElseThrow(()-> new ResourceNotFoundException("dniEmployee", dniEmployee));
		User user =userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(()-> new ResourceNotFoundException("username o email",  usernameOrEmail));
		Sale sale= saleRepository.findByDni(dniSale).orElseThrow(()-> new ResourceNotFoundException("dni de sala",  dniSale));
		
		if(!employee.getUser().equals(user))
		{
			employee.setUser(user);
		}
		if (!employee.getSale().equals(sale))
		{
			employee.setSale(sale);
		}
		userRepository.save(user);
		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO DeleteEmployee(String dni) {
		Employee employee= employeeRepository.findByDni(dni).orElseThrow(()-> new ResourceNotFoundException("dni", dni));
		employeeRepository.delete(employee);
		return mapper.map(employee, EmployeeDTO.class);
	}

	
}
