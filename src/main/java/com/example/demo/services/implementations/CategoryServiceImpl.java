package com.example.demo.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public List<CategoryDTO> GetAllCategories() {
		
	List<Category> categories= categoryRepository.findAll();
	return categories.stream().map((category)->mapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO FindCategoryById(long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id", Long.toString(id)));
		return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO FindCategoryByCod(String cod) {
		Category category = categoryRepository.findByCod(cod).orElseThrow(()->
		new ResourceNotFoundException("id", cod));
		return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO AddCategory(CategoryDTO category) {
		//verificar primero si el cod ya se encuentra regisrtrado
		categoryRepository.findByCod(category.getCod()).orElse(null);
		if (!category.equals(null))
		{
			throw new  ResourceDuplicatedException("cod ", category.getCod());
		}
		
		Category categoryResponse= categoryRepository.save(mapper.map(category, Category.class));
		return mapper.map(categoryResponse, CategoryDTO.class);
		
	}

	@Override
	public CategoryDTO UpdateCategory(CategoryDTO category, long id) {
		Category categoryExist=categoryRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id", Long.toString(id)));
		
		if (!category.getCod().equals(categoryExist.getCod()))
				categoryExist.setCod(category.getCod());
		
		categoryExist.setName(category.getName());
		Category updated=categoryRepository.save(categoryExist);
		return mapper.map(updated, CategoryDTO.class);
	}

	@Override
	public CategoryDTO DeleteCategory(String cod) {
		Category categoryExist=categoryRepository.findByCod(cod).orElseThrow(()->
		new ResourceNotFoundException("cod", cod));
		categoryRepository.delete(categoryExist);;
		return mapper.map(categoryExist, CategoryDTO.class);
	}

}
