package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.example.demo.Payments.Kind;

@Service
public class MyService {

	@Autowired
	PaymentsRepository PaymentsRepository;

	//収支毎に
	public List<Payments> getAllByKind(Kind kind, int user) {
		List<Payments> list = null;
		if (user != 0)
			list = PaymentsRepository.findAllByKindAndUserId(kind, user);
		else
			list = PaymentsRepository.findAllByKind(kind);
		return list;
	}

	//	収支毎にカテゴリでソート
	public List<Payments> getKindSortedByCategory(Kind kind, int user) {
		List<Payments> Payments;
		if (user != 0) {
			Payments = PaymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Payments = PaymentsRepository.findAllByKind(kind);
		}
		return Payments.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getCategory_id(), t2.getCategory_id()))
				.collect(Collectors.toList());
	}

	//	収支毎に日付でソート
	public List<Payments> getKindSortedByDate(Kind kind, int user) {
		List<Payments> Payments;
		if (user != 0) {
			Payments = PaymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Payments = PaymentsRepository.findAllByKind(kind);
		}
		return Payments.stream()
				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
				.collect(Collectors.toList());
	}

	//	収支毎に金額でソート
	public List<Payments> getKindSortedByAmount(Kind kind, int user) {
		List<Payments> Payments;
		if (user != 0) {
			Payments = PaymentsRepository.findAllByKindAndUserId(kind, user);
		} else {
			Payments = PaymentsRepository.findAllByKind(kind);
		}
		return Payments.stream()
				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

	public void editTodo(Payments ex) {
		PaymentsRepository.save(ex);
	}

	public void deleteTodo(int id) {
		PaymentsRepository.deleteById(id);
	}

	public void addTodo(Payments ex) {
		PaymentsRepository.save(ex);
	}
}