package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HouseHold;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Payment.Kind;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	/*
	 * ソート系
	 */
	public List<Payment> findAll();
	
	public List<Payment> findByHouseHold(HouseHold household);

	public List<Payment> findByKind(Kind kind);

	public List<Payment> findByDate(LocalDate date);

	public List<Payment> findByAmount(int amount);

	public List<Payment> findByDateAndUserId(LocalDate date, long user);

	public List<Payment> findByAmountAndUserId(int amount, long user);

	public List<Payment> findByKindAndUserId(Kind kind, long user);

	/*
	 * データ持ってくる系
	 */

	public List<Payment> findAllByKind(Kind kind);

	public List<Payment> findAllByKindAndUserId(Kind kind, int user);
}
