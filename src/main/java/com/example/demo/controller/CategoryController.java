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

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> GetAllCategories(){
		return ResponseEntity.ok(categoryService.GetAllCategories());
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> FindCategoryById(@PathVariable(name = "id")long id)
	{
		return ResponseEntity.ok(categoryService.FindCategoryById(id));
	}
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	@GetMapping("/{codCategory}")
	public ResponseEntity<CategoryDTO> FindCategoryByCod(@PathVariable(name = "codCategory")String codCategory)
	{
		return ResponseEntity.ok(categoryService.FindCategoryByCod(codCategory));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<CategoryDTO> AddCategory(@Valid @RequestBody CategoryDTO category)
	{
		return ResponseEntity.ok(categoryService.AddCategory(category));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> UpdateCategory(
			@PathVariable(name = "id")long id
			,@Valid @RequestBody CategoryDTO category)
	{
		return ResponseEntity.ok(categoryService.UpdateCategory(category, id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{codCategory}")
	public ResponseEntity<CategoryDTO> DeleteCategoryByCod(@PathVariable(name = "codCategory")String codCategory)
	{
		return ResponseEntity.ok(categoryService.DeleteCategory(codCategory));
	}
	
}
