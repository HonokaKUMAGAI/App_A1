package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
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

//	public void setTargetAmount(int amount) {
//
//		TargetSetting.setCategoryList();
//		TargetSetting.setHouseholdList();
//		TargetSetting.setTargetAmount(amount);
//
//	}
}
