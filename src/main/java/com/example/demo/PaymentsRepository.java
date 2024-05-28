package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Payments.Kind;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
	public List<Payments> findAllByKindAndUserId(Kind kind, int user) ;

	public List<Payments> findAllByKind(Payments.Kind kind) ;
	
	public List<Payments> findAllByCategoryId(long Id) ;
}