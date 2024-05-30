package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Payments.Kind;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

	/*
	 * データ持ってくる系
	 */
	public List<Payments> findAll() ;
	
	public List<Payments> findByKind(Kind kind) ;
	public List<Payments> findByDate(LocalDate date) ;
	public List<Payments> findByAmount(int amount) ;
	public List<Payments> findByCategoryId(Long categoryId);

	public List<Payments> findByDateAndUserId(LocalDate date, long user) ;
	public List<Payments> findByAmountAndUserId(int amount, long user) ;
	public List<Payments> findByKindAndUserId(Kind kind, long user) ;
	public List<Payments> findByCategoryIdAndUserId(Long categoryId, long user);

	/*
	 * ソート系
	 */
    public List<Payments> findAllByKind(Kind kind);
	public List<Payments> findAllByKindAndUserId(Kind kind, long user);

	public List<Payments> findAllByDate(LocalDate date);
	public List<Payments> findAllByDateAndUserId(LocalDate date, long user);
	
	public List<Payments> findAllByAmount(int amount);
	public List<Payments> findAllByAmountAndUserId(int amount, long user);
	
//	public List<Payments> findAllByCategoryId();
//	public List<Payments> findAllByKind();
//	public List<Payments> findAllByDate();
//	public List<Payments> findAllByAmount();
	public List<Payments> findByUserIdOrderByCategoryId(long user);
	public List<Payments> findAllByOrderByCategoryId();
//	public List<Payments> findAllByOrderBycategoryId();
	
	public List<Payments> findByUserIdOrderByDate(long user);
	
	public List<Payments> findAllByOrderByDate();
	
	public List<Payments> findAllByOrderByAmount();
	public List<Payments> findByUserIdOrderByAmount(long user);
	
	public List<Payments> findAllByCategoryId(Long categoryId);
	public List<Payments> findAllByCategoryIdAndUserId(Long categoryId, long user);
	
	
	public List<Payments>findByAmountGreaterThanEqual(int amount);
	public List<Payments>findByAmountGreaterThanEqualAndUserId(int amount, long user);
	public List<Payments>findByDateGreaterThanEqual(LocalDate date);
	public List<Payments>findByDateGreaterThanEqualAndUserId(LocalDate date, long user);
	public List<Payments>findByCategoryIdGreaterThanEqual(Long categoryId);
	public List<Payments>findByCategoryIdGreaterThanEqualAndUserId(Long categoryId, long user);

}