package com.example.demo.DTO;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.models.Category;

public class ProductDTO {
	private Long id;
	@NotNull(message =  "el atributo name es obligatorio")
	@NotEmpty(message =  "el atributo name es obligatorio")
	private String name;
	@NotNull(message =  "el atributo category es obligatorio")
	@NotEmpty(message =  "el atributo category es obligatorio")
	private Category category;
	@NotNull(message =  "el atributo price es obligatorio")
	@NotEmpty(message =  "el atributo price es obligatorio")
	private double price;
	@NotNull(message =  "el atributo stock es obligatorio")
	@NotEmpty(message =  "el atributo stock es obligatorio")
	private int stock;
	@NotNull(message =  "el atributo discount es obligatorio")
	@NotEmpty(message =  "el atributo discount es obligatorio")
	private int discount;

	private String codProduct;
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getCodProduct() {
		return codProduct;
	}
	public void setCodProduct(String codProduct) {
		this.codProduct = codProduct;
	}
	public ProductDTO(Long id,
			@NotNull(message = "el atributo name es obligatorio") @NotEmpty(message = "el atributo name es obligatorio") String name,
			@NotNull(message = "el atributo category es obligatorio") @NotEmpty(message = "el atributo category es obligatorio") Category category,
			@NotNull(message = "el atributo price es obligatorio") @NotEmpty(message = "el atributo price es obligatorio") double price,
			@NotNull(message = "el atributo stock es obligatorio") @NotEmpty(message = "el atributo stock es obligatorio") int stock,
			@NotNull(message = "el atributo discount es obligatorio") @NotEmpty(message = "el atributo discount es obligatorio") int discount,
			String codProduct) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discount = discount;
		this.codProduct = codProduct;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
