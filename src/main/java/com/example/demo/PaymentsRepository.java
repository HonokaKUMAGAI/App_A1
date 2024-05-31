package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Payments.Kind;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
	public List<Payments> findAllByKindAndUserIdAndHouseholdId(Kind kind, long user,long hh) ;	//家計簿、収支の種類、ユーザー毎に取得

	public List<Payments> findAllByKindAndHouseholdId(Payments.Kind kind,long hh) ;	//家計簿、収支の種類毎に取得
	
	//public Payments findAllByCategoryIdAndhouseHoldId(long Id,long hh) ;	
	 List<Payments> findByCategoryIdIn(List<Category> categories);
	 
}