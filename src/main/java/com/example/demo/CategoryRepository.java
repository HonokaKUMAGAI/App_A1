package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Category.Kind;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public List<Category> findAllByKind(Kind kind);

}