package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Budget.Kind;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {
	public List<Budget> findAllByKindAndUserId(Kind kind, int user) ;
	public List<Budget> findAllByKind(Budget.Kind kind) ;

}