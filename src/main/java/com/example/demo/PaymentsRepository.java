package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Payments.Kind;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

	/*
	 * ソート系
	 */
	public List<Payments> findAll() ;
	
	public List<Payments> findByKind(Kind kind) ;
	public List<Payments> findByDate(LocalDate date) ;
	public List<Payments> findByAmount(int amount) ;

	public List<Payments> findByDateAndUserId(LocalDate date, long user) ;
	public List<Payments> findByAmountAndUserId(int amount, long user) ;
	public List<Payments> findByKindAndUserId(Kind kind, long user) ;
	
	/*
	 * データ持ってくる系
	 */

    public List<Payments> findAllByKind(Kind kind);
	public List<Payments> findAllByKindAndUserId(Kind kind, int user);
//	public List<Payments> findAllByKind(Kind kind, int user);
	
	/*
	 * カテゴリごとの集計（複数選択対応）
	 */
	List<Payments> findByCategoryIn(List<String> categories);

}