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
			list = expensesRepository.findAllByKindAndUserId(kind, user);
		else
			list = expensesRepository.findAllByKind(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Expenses> getKindSortedByCategory(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Expenses> getKindSortedByDate(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Expenses> getKindSortedByAmount(Kind kind, int user) {
		List<Expenses> Expenses;
		if (user != 0) {
			Expenses = expensesRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = expensesRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

//	収支編集
	public void editExpense(Expenses ex) {
		expensesRepository.save(ex);
	}
//  収支削除
	public void deleteExpenses(long id) {
		expensesRepository.deleteById(id);
	}
//  収支追加
	public void addExpenses(Expenses ex) {
		expensesRepository.save(ex);
	}
	
	@Autowired
	CategoryRepository categoryRepository;
	
//	カテゴリ追加
	public void addCategory(Category ca) {
		categoryRepository.save(ca);
	}
//	カテゴリ編集
	public void editCategory(Category ca) {
		categoryRepository.save(ca);
	}
//	カテゴリ削除
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
	
	public void setTarget() {
		TargetSetting.setTarget();
	}
	
}
