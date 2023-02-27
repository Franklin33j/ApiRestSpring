package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@ManyToOne
	@JoinColumn(name= "category_id")
	private Category category;
	private double price;
	@Column(unique = true)
	private String codProduct;
	private int stock;
	private int discount;
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
	public Product(Long id, String name, Category category, double price, String codProduct, int stock, int discount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.codProduct = codProduct;
		this.stock = stock;
		this.discount = discount;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
