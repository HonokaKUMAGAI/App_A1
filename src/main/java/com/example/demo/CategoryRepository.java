package com.example.demo;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public List<Category> findAllByKindsAndUserId(int kind, int user) ;

	public List<Category> findAllByKinds(int kind) ;

}
