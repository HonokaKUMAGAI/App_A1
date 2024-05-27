package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Expenses.Kind;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
	public List<Expenses> findAllByKindsAndUserId(Kind kind, int user) ;

	public List<Expenses> findAllByKinds(Expenses.Kind kind) ;

}