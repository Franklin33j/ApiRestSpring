package com.example.demo.DTO;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.models.Role;


public class UserDTO {

	private Long id;

	@NotEmpty(message = "El atributo firtsName es obligatorio")
	@Size(max = 100, message = "El atributo firtsName requiere unicamente solo 100 numeros")
	private String firstNames;
	@NotEmpty(message = "El atributo lastName es obligatorio")
	@Size(max = 100, message = "El atributo lastsName requiere unicamente solo 100 numeros")
	private String lastNames;
	@Email(message = "El campo no tiene un valor valido para el correo")
	private String email;
	@NotNull(message = "El atributo age es obligatorio")
	private Integer age;
	@NotEmpty(message = "El atributo address obligatorio")
	private String address;
	@NotEmpty(message = "El atributo username es obligatorio")
	@Size(max = 100, message = "El atributo username requiere unicamente solo 100 numeros")
	private String username;
	@NotEmpty(message = "El atributo password es obligatorio")
	@Size(max = 100,message = "El atributo password requiere unicamente solo 100 numeros")
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
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Long id,
			@NotEmpty(message = "El atributo firtsName es obligatorio") @Size(max = 100, message = "El atributo firtsName requiere unicamente solo 100 numeros") String firstNames,
			@NotEmpty(message = "El atributo lastName es obligatorio") @Size(max = 100, message = "El atributo lastsName requiere unicamente solo 100 numeros") String lastNames,
			@Email(message = "El campo no tiene un valor valido para el correo") String email,
			@NotNull(message = "El atributo age es obligatorio") Integer age,
			@NotEmpty(message = "El atributo address obligatorio") String address,
			@NotEmpty(message = "El atributo username es obligatorio") @Size(max = 100, message = "El atributo username requiere unicamente solo 100 numeros") String username,
			@NotEmpty(message = "El atributo password es obligatorio") @Size(max = 100, message = "El atributo password requiere unicamente solo 100 numeros") String password,
			Set<Role> roles) {
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
	
}
