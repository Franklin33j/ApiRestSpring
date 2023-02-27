package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.CategoryDTO;


public interface CategoryService {

	List<CategoryDTO> GetAllCategories();
	CategoryDTO FindCategoryById(long id);
	CategoryDTO FindCategoryByCod(String cod);
	CategoryDTO AddCategory(CategoryDTO category);
	CategoryDTO UpdateCategory(CategoryDTO category, long id);
	CategoryDTO DeleteCategory(String cod);
}
