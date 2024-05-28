package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Payments.Kind;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
	public List<Payments> findAllByKindAndUserId(Kind kind, int user) ;
	public List<Payments> findAllByKind(Payments.Kind kind) ;

}