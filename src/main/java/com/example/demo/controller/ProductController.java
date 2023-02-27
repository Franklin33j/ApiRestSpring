package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productService;
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<ProductDTO>> GetAllProducts()
	{
		return ResponseEntity.ok(productService.GetAllProducts());
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@GetMapping("/{codProduct}")
	public ResponseEntity<ProductDTO> FindProductByCod(@PathVariable(name = "codProduct")String codProduct)
	{
		return ResponseEntity.ok(productService.findProductByCod(codProduct));
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@PostMapping
	public ResponseEntity<ProductDTO> AddProduct(@Valid @RequestBody ProductDTO product)
	{
		return ResponseEntity.ok(productService.AddProduct(product));
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@PutMapping("/{codProduct}")
	public ResponseEntity<ProductDTO> UpdateProduct(@PathVariable(name = "codProduct")String codProduct,
			@RequestBody ProductDTO product)
	{
		return ResponseEntity.ok(productService.UpdateProduct(product, codProduct));
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@DeleteMapping("/{codProduct}")
	public  ResponseEntity< ProductDTO> DeleteProductByCod(@PathVariable(name = "codProduct")String codProduct)
	{
		return ResponseEntity.ok(productService.DeleteProduct(codProduct));
	}

}
