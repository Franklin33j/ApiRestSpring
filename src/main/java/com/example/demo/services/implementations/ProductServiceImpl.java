package com.example.demo.services.implementations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public List<ProductDTO> GetAllProducts() {
		
		List<Product> products= productRepository.findAll();
		return products.stream().map(product->mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ProductDTO findProductByCod(String codProduct) {
		Product product = productRepository.findByCodProduct(codProduct).orElseThrow(()->
		new ResourceNotFoundException("codProduct", codProduct));
		return mapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO AddProduct(ProductDTO product) {
		//buscar si la categoria es valida
		Category category= categoryRepository.findByCod(product.getCategory().getCod()).orElseThrow(()->
		new ResourceNotFoundException("codCategory",product.getCategory().getCod()));
		
		Random rand= new Random();
		String cod= Integer.toString(rand.nextInt(999999));
		//buscar en la db si ya existe ese cod
		Product codExist= productRepository.findByCodProduct(cod).orElse(null);
		while(codExist!=null) {
			codExist= productRepository.findByCodProduct(cod).orElse(null);
		}
		product.setCodProduct(cod);
		product.setCategory(category);
		Product productResponse= productRepository.save(mapper.map(product, Product.class));
		return mapper.map(productResponse, ProductDTO.class);
	}

	@Override
	public ProductDTO UpdateProduct(ProductDTO product, String codProduct) {
		Product productExist= productRepository.findByCodProduct(codProduct).orElseThrow(()->
		new ResourceNotFoundException("codProduct", codProduct));
		//buscar si la categoria es valida
		Category category= categoryRepository.findByCod(product.getCategory().getCod()).orElseThrow(()->
		new ResourceNotFoundException("codCategory",product.getCategory().getCod()));
		
		product.setCategory(category);
		product.setCodProduct(null);
		Product productResponse=productRepository.save(mapper.map(product, Product.class));
		return mapper.map(productResponse, ProductDTO.class);
	}

	@Override
	public ProductDTO DeleteProduct(String codProduct) {
		Product product = productRepository.findByCodProduct(codProduct).orElseThrow(()->
		new ResourceNotFoundException("codProduct", codProduct));
		productRepository.delete(product);
		return mapper.map(product, ProductDTO.class);
	}

}
