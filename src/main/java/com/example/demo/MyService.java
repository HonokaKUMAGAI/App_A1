package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.example.demo.Payments.Kind;

@Service
public class MyService {

	@Autowired
	PaymentsRepository paymentsRepository;

	//収支毎に
	public List<Payments> getAllByKind(Kind kind, int user) {
		List<Payments> list = null;
		if (user != 0)
			list = paymentsRepository.findAllByKindAndUserId(kind, user);
		else
			list = paymentsRepository.findAllByKind(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Payments> getKindSortedByCategory(Kind kind, int user) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = paymentsRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Payments> getKindSortedByDate(Kind kind, int user) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = paymentsRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Payments> getKindSortedByAmount(Kind kind, int user) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Expenses = paymentsRepository.findAllByKind(kind);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

//	収支編集
	public void editExpense(Payments pay) {
		paymentsRepository.save(pay);
	}
//  収支削除
	public void deleteExpenses(long id) {
		paymentsRepository.deleteById(id);
	}
//  収支追加
	public void addExpenses(Payments pay) {
		paymentsRepository.save(pay);
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
	
//	public void setTarget() {
//		TargetSetting.setTarget();
//	}
	
}
