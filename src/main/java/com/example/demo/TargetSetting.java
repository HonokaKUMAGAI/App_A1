//package com.example.demo;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class TargetSetting {
//
//	@Autowired
//	CategoryRepository categoryRepository;
//	private static List<Category> categoryList;
//
//	@Autowired
//	static
//	TargetRepository targetRepository;
//	
//	private void setCategoryList() {
//		categoryList = categoryRepository.findAll();
//	}
//
//	public static void setTarget() {
//		Target target=null;
//		for(Category category:categoryList) {
//			target.setTargetAmounf(0);
//			targetRepository.save(target);
//		}
//	}
//}
