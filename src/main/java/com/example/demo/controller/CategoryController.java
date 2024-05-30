package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class CategoryController {
	
	private final CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}


}
