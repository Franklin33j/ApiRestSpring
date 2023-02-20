package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.SaleDTO;

public interface SaleService {

	 List<SaleDTO> GetAllSales();
	 SaleDTO FindById(long id);
	 SaleDTO AddSale(SaleDTO sale);
	 SaleDTO UpdateSale(SaleDTO sale, long id);
	 SaleDTO DeleteSale(Long id);
	 
}
