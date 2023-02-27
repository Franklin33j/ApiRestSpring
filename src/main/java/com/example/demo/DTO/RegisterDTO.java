package com.example.demo.DTO;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"roles"})
public class RegisterDTO {

	private Long id;
	
	@NotNull(message = "El campo firtsNames es obligatorio")
	@NotEmpty(message = "El campo firstNames es obligatorio")
	private String firstNames;
	
	@NotNull(message = "El campo lastNames es obligatorio")
	@NotEmpty(message = "El campo lasNames es obligatorio")
	private String lastNames;
	
	@NotNull(message = "El campo email es obligatorio")
	@NotEmpty(message = "El campo email es obligatorio")
	@Email(message = "El campo email debe poseer un formato correcto")
	private String email;
	
	@NotNull(message = "El campo age es obligatorio")
	
	private Integer age;
	
	@NotNull(message = "El campo address es obligatorio")
	@NotEmpty(message = "El campo address es obligatorio")
	private String address;
	
	@NotNull(message = "El campo username es obligatorio")
	@NotEmpty(message = "El campo username es obligatorio")
	private String username;
	
	@NotNull(message = "El campo password es obligatorio")
	@NotEmpty(message = "El campo password es obligatorio")
	private String password;
	
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public RegisterDTO(Long id, String firstNames, String lastNames, String email, Integer age, String address,
			String username, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.firstNames = firstNames;
		this.lastNames = lastNames;
		this.email = email;
		this.age = age;
		this.address = address;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
