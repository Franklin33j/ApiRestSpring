package com.example.demo.DTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.models.Product;

public class CategoryDTO {

	
	
	private Long id;
	@NotNull(message = "El atributo name es obligatorio")
	@NotEmpty(message = "El atributo name es obligatorio")
	private String name;
	@NotNull(message = "El atributo cod es obligatorio")
	@NotEmpty(message = "El atributo cod es obligatorio")
	@Size(min = 5, max= 5, message = "El atributo cod solo debe contener 5 numeros")
	private String cod;
	
    private List<Product> products ;

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

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public CategoryDTO(Long id,
			@NotNull(message = "El atributo name es obligatorio") @NotEmpty(message = "El atributo name es obligatorio") String name,
			@NotNull(message = "El atributo cod es obligatorio") @NotEmpty(message = "El atributo cod es obligatorio") @Size(min = 5, max = 5, message = "El atributo cod solo debe contener 5 numeros") String cod,
			List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.cod = cod;
		this.products = products;
	}

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


    
}
