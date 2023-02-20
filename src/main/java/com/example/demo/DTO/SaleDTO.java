package com.example.demo.DTO;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaleDTO {
	private Long id;
	@NotEmpty(message = "El atributo dni es obligatorio")
	@NotNull(message = "El atributo dni no puede ser nulo")
	@Size(max = 6, min = 6 ,message = "El atributo dni requiere unicamente solo 6 numeros")
	private String dni;
	@NotNull(message = "El atributo name no puede ser nulo")
	@NotEmpty(message = "El atributo name es obligatorio")
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SaleDTO(Long id,
			@NotEmpty(message = "El atributo dni es obligatorio") @Size(max = 6, min = 6, message = "El atributo dni requiere unicamente solo 6 numeros") String dni,
			@NotEmpty(message = "El atributo name es obligatorio") String name) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
	}
	public SaleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
