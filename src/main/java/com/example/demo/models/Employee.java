package com.example.demo.models;



import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})} )
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	@Column(length = 4, unique = true)
	private String dni;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sale_id")
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

	public Employee(Long id, User user, String dni) {
		super();
		this.id = id;
		this.user = user;
		this.dni = dni;
		
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User SetPasswordUser(String password)
	{
		this.user.setPassword(password);
		return this.user;
	}
	
	
	
}
