package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TargetSetting {

	@Autowired
	static
	CategoryRepository categoryRepository;
	private static List<Category> categoryList;
	public static void setCategoryList() {
		categoryList = categoryRepository.findAll();
	}

	@Autowired
	static
	HouseHoldRepository houseHoldRepository;
	private static List<HouseHold> houseHoldList;
	public static void setHouseholdList() {
		houseHoldList = houseHoldRepository.findAll();
	}
	
	@Autowired
	static TargetRepository targetRepository;

	public static void setTargetAmount(int amount) {
		Target target = null;
		for (HouseHold houseHold : houseHoldList) {
			target.setHouseHoldId(houseHold.getHouseHoldId());
			for (Category category : categoryList) {
				target.setCategoryId(category.getCategoryId());
				target.setTargetAmounf(amount);
				targetRepository.save(target);
			}
		}
	}
	
}
