package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.example.demo.Budget.Kind;

@Service
public class MyService {

	@Autowired
	BudgetRepository BudgetRepository;

	//収支毎に
	public List<Budget> getAllByKind(Kind kind, int user) {
		List<Budget> list = null;
		if (user != 0)
			list = BudgetRepository.findAllByKindAndUserId(kind, user);
		else
			list = BudgetRepository.findAllByKind(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Budget> getKindSortedByCategory(Kind kind, int user) {
		List<Budget> Budget;
		if (user != 0) {
			Budget = BudgetRepository.findAllByKindAndUserId(kind, user);
		} else {
			Budget = BudgetRepository.findAllByKind(kind);
		}
		return Budget.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getCategory_id(), t2.getCategory_id()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Budget> getKindSortedByDate(Kind kind, int user) {
		List<Budget> Budget;
		if (user != 0) {
			Budget = BudgetRepository.findAllByKindAndUserId(kind, user);
		} else {
			Budget = BudgetRepository.findAllByKind(kind);
		}
		return Budget.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Budget> getKindSortedByAmount(Kind kind, int user) {
		List<Budget> Budget;
		if (user != 0) {
			Budget = BudgetRepository.findAllByKindAndUserId(kind, user);
		} else {
			Budget = BudgetRepository.findAllByKind(kind);
		}
		return Budget.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

	public void editTodo(Budget ex) {
		BudgetRepository.save(ex);
	}

	public void deleteTodo(int id) {
		BudgetRepository.deleteById(id);
	}

	public void addTodo(Budget ex) {
		BudgetRepository.save(ex);
	}
}