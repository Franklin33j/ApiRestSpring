package com.example.demo.DTO;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.demo.models.Role;
import com.example.demo.models.Sale;
import com.example.demo.models.User;

public class EmployeeDTO {

	
	private Long id;
	
	@NotEmpty(message = "el atributo id de User es obligatorio")
	private User user;
	@NotEmpty(message = "El atributo dni es obligatorio")
	@Size(max = 4, min = 4 ,message = "El atributo dni requiere unicamente 4 numeros")
	private String dni;
	/*
	 * Se omitira roles para que unicamente el sistema los agregue
	 * 
	 * @NotEmpty(message = "El rol es obligatorio")
	@Size(max = 4, min = 4 ,message = "El dni requiere unicamente 4 numeros")
	private  Set<Role> roles;
	*/
	@NotEmpty(message = "El atributo id de Sale es obligatorio")
	private Sale sale;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public EmployeeDTO(Long id, @NotEmpty(message = "el atributo id de User es obligatorio") User user,
			@NotEmpty(message = "El atributo dni es obligatorio") @Size(max = 4, min = 4, message = "El atributo dni requiere unicamente 4 numeros") String dni,
			@NotEmpty(message = "El atributo id de Sale es obligatorio") Sale sale) {
		super();
		this.id = id;
		this.user = user;
		this.dni = dni;
		this.sale = sale;
	}
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
