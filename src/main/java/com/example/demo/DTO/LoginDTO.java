package com.example.demo.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull(message = "El campo email es obligatorio")
	@NotEmpty(message = "El campo email es obligatorio")
	private String email;
	@NotNull(message = "El campo password es obligatorio")
	@NotEmpty(message = "El campo password es obligatorio")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDTO(
			@NotNull(message = "El campo email es obligatorio") @NotEmpty(message = "El campo email es obligatorio") String email,
			@NotNull(message = "El campo password es obligatorio") @NotEmpty(message = "El campo password es obligatorio") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
