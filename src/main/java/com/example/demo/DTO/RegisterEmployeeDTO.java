package com.example.demo.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterEmployeeDTO {

	@NotEmpty(message = "El atributo usernameOrEmail es obligatorio")
	@NotNull(message = "El atributo usernameOrEmail es obligatorio")
	private String usernameOrEmail;
	
	@NotEmpty(message = "El atributo dniSale es obligatorio")
	@NotNull(message = "El atributo dniSale es obligatorio")
	private String dniSale;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}


	public String getDniSale() {
		return dniSale;
	}

	public void setDniSale(String  dniSale) {
		this.dniSale = dniSale;
	}

	public RegisterEmployeeDTO(
			@NotEmpty(message = "El atributo usernameOrEmail es obligatorio") @NotNull(message = "El atributo usernameOrEmail es obligatorio") String usernameOrEmail,
			@NotNull(message = "El atributo dniSale es obligatorio") @NotEmpty(message = "El atributo dniSale es obligatorio") String  dniSale) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.dniSale = dniSale;
	}

	public RegisterEmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
