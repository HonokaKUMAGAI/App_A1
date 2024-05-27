package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	ExpensesRepository expensesRepo;

	//収支毎に
	public List<Expenses> getKind(int kind, int user) {
		List<Expenses> list = null;
		if (user != 0)
			list = expensesRepo.findAllByKindsAndUserId(kind, user);
		else
			list = expensesRepo.findAllByKinds(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Expenses> getKindSortedByCategory(int kind, int user) {
		List<Expenses> categories;
        if (user != 0) {
            categories = expensesRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = expensesRepo.findAllByKinds(kind);
        }
        return categories.stream()
                .sorted((t1, t2) -> Integer.compare(t1.getCategory_id(), t2.getCategory_id()))
                .collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Expenses> getKindSortedByDate(int kind, int user) {
		List<Expenses> categories;
        if (user != 0) {
            categories = expensesRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = expensesRepo.findAllByKinds(kind);
        }
		return categories.stream()
				.sorted((t1, t2) -> t1.getDate().compareToIgnoreCase(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Expenses> getKindSortedByAmount(int kind, int user) {
		List<Expenses> categories;
        if (user != 0) {
            categories = expensesRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = expensesRepo.findAllByKinds(kind);
        }
		return categories.stream()
				.sorted((t1, t2) -> t1.getAmount().compareToIgnoreCase(t2.getAmount()))
				.collect(Collectors.toList());
	}
}
