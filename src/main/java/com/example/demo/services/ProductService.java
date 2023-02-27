package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.ProductDTO;

public interface ProductService {

	List<ProductDTO> GetAllProducts();
	ProductDTO findProductByCod(String codProduct);
	ProductDTO AddProduct(ProductDTO product);
	ProductDTO UpdateProduct(ProductDTO product, String codProduct);
	ProductDTO DeleteProduct(String codProduct);
}
