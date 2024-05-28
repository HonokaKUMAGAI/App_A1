package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Expenses.Kind;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	public List<Expenses> findAllByKindAndUserId(Kind kind, int user) ;

	public List<Expenses> findAllByKind(Expenses.Kind kind) ;

}