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

import com.example.demo.DTO.SaleDTO;
import com.example.demo.services.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

	@Autowired
	SaleService saleService;
	@GetMapping
	public ResponseEntity<List<SaleDTO>> GetAllSales()
	{
		return ResponseEntity.ok(saleService.GetAllSales());
	}
	@GetMapping("/{id}")
	public ResponseEntity<SaleDTO> GetSaleById(@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(saleService.FindById(id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<SaleDTO> AddSale(
			@Valid @RequestBody SaleDTO sale)
	{
		return ResponseEntity.ok(saleService.AddSale(sale));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<SaleDTO> UpdateSale(
			@PathVariable(name = "id")long id,
			@Valid @RequestBody SaleDTO sale )
	{
		SaleDTO saleResponse= saleService.UpdateSale(sale, id);
		return ResponseEntity.ok(saleResponse);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<SaleDTO> DeleteSale(
			@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(saleService.DeleteSale(id));
	}
	
}
