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

	//収支毎に取得　ユーザー毎に取得可能
	public List<Payments> getAllByKind(Kind kind, long user,long hh) {
		List<Payments> list = null;
		if (user != 0)
			list = paymentsRepository.findAllByKindAndUserIdAndhouseHoldId(kind, user,hh);
		else
			list = paymentsRepository.findAllByKindAndhouseHoldId(kind,hh);
		return list;
	}

	//	収支毎にカテゴリでソート　ユーザー毎に取得可能
	public List<Payments> getKindSortedByCategory(Kind kind, long user,long hh) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserIdAndhouseHoldId(kind, user,hh);
		} else {
			Expenses = paymentsRepository.findAllByKindAndhouseHoldId(kind,hh);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート　ユーザー毎に取得可能
	public List<Payments> getKindSortedByDate(Kind kind, long user,long hh) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserIdAndhouseHoldId(kind, user,hh);
		} else {
			Expenses = paymentsRepository.findAllByKindAndhouseHoldId(kind,hh);
		}
		return Expenses.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート　ユーザー毎に取得可能
	public List<Payments> getKindSortedByAmount(Kind kind, long user,long hh) {
		List<Payments> Expenses;
		if (user != 0) {
			Expenses = paymentsRepository.findAllByKindAndUserIdAndhouseHoldId(kind, user,hh);
		} else {
			Expenses = paymentsRepository.findAllByKindAndhouseHoldId(kind,hh);
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
	
//	目標金額設定
	public void setTargetAmount(int amount) {
		
		TargetSetting.setCategoryList();
		TargetSetting.setHouseholdList();
		TargetSetting.setTargetAmount(amount);
		
	}
    
    public List<Payments> findAll() {
        return paymentsRepository.findAll();
    }
    
    public List<Payments> getKakeiboByCategories(List<String> categories) {
        return paymentsRepository.findByCategoryIn(categories);
    }
    
    public Payments save(Payments kakeibo) {
        return paymentsRepository.save(kakeibo);
    }
	
}
