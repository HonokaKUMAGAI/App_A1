package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TargetSetting {

	@Autowired
	static CategoryRepository categoryRepository;
	private static List<Category> categoryList;

	public static void setCategoryList() {
		categoryList = categoryRepository.findAll();
	}

	@Autowired
	static HouseHoldRepository houseHoldRepository;
	private static List<HouseHold> houseHoldList;

	public static void setHouseholdList() {
		houseHoldList = houseHoldRepository.findAll();
	}

	//	目標金額の設定
	@Autowired
	static TargetRepository targetRepository;

	public static void setTargetAmount(int amount, HouseHold houseHold, Category category) {
		Target target = null;
		target.setHouseHoldId(houseHold.getHouseHoldId());
		target.setCategoryId(category.getCategoryId());
		target.setTargetAmounf(amount);
		targetRepository.save(target);

	}

}
