package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
	public List<Expenses> findAllByKindsAndUserId(int kind, int user) ;

	public List<Expenses> findAllByKinds(int kind) ;

}
