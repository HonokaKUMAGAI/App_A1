package com.example.demo;

import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	CategoryRepository categoryRepo;

	//収支毎に
	public List<Category> getKind(int kind, int user) {
		List<Category> list = null;
		if (user != 0)
			list = categoryRepo.findAllByKindsAndUserId(kind, user);
		else
			list = categoryRepo.findAllByKinds(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Category> getKindSortedByCategory(int kind, int user) {
		List<Category> categories;
        if (user != 0) {
            categories = categoryRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = categoryRepo.findAllByKinds(kind);
        }
        return categories.stream()
                .sorted((t1, t2) -> Integer.compare(t1.getCategory_id(), t2.getCategory_id()))
                .collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Category> getKindSortedByDate(int kind, int user) {
		List<Category> categories;
        if (user != 0) {
            categories = categoryRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = categoryRepo.findAllByKinds(kind);
        }
		return categories.stream()
				.sorted((t1, t2) -> t1.getDate().compareToIgnoreCase(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Category> getKindSortedByAmount(int kind, int user) {
		List<Category> categories;
        if (user != 0) {
            categories = categoryRepo.findAllByKindsAndUserId(kind, user);
        } else {
            categories = categoryRepo.findAllByKinds(kind);
        }
		return categories.stream()
				.sorted((t1, t2) -> t1.getAmount().compareToIgnoreCase(t2.getAmount()))
				.collect(Collectors.toList());
	}
}
