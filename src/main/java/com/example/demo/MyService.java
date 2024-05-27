package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.example.demo.Expenses.Kind;

@Service
public class MyService {

	@Autowired
	ExpensesRepository expensesRepository;

	//収支毎に
	public List<Expenses> getAllByKind(Kind kind, int user) {
		List<Expenses> list = null;
		if (user != 0)
			list = expensesRepository.findAllByKindsAndUserId(kind, user);
		else
			list = expensesRepository.findAllByKinds(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Expenses> getKindSortedByCategory(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindsAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKinds(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getCategory_id(), t2.getCategory_id()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Expenses> getKindSortedByDate(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindsAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKinds(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Expenses> getKindSortedByAmount(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindsAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKinds(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

	public void editTodo(Expenses ex) {
		expensesRepository.save(ex);
	}

	public void deleteTodo(int id) {
		expensesRepository.deleteById(id);
	}

	public void addTodo(Expenses ex) {
		expensesRepository.save(ex);
	}
}
