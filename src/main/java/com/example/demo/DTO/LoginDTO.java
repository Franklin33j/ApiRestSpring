package com.example.demo.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull(message = "El campo username es obligatorio")
	@NotEmpty(message = "El campo username es obligatorio")
	private String username;
	@NotNull(message = "El campo password es obligatorio")
	@NotEmpty(message = "El campo password es obligatorio")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginDTO(
			@NotNull(message = "El campo username es obligatorio") @NotEmpty(message = "El campo username es obligatorio") String username,
			@NotNull(message = "El campo password es obligatorio") @NotEmpty(message = "El campo password es obligatorio") String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
