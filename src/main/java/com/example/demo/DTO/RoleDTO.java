package com.example.demo.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleDTO {
	private Long id;
	@NotEmpty(message = "El atributo name es obligatorio")
	@Size(max = 100,message = "El atributo name requiere unicamente solo 100 numeros")
	@NotNull(message = "El atributo name no puede ser nulo")
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoleDTO(Long id,
			@NotEmpty(message = "El atributo name es obligatorio") @Size(max = 100, min = 100, message = "El atributo name requiere unicamente solo 100 numeros") String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
