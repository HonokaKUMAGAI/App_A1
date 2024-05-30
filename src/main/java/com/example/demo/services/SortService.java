package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HouseHold;
import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SortService {

	private final PaymentRepository paymentRepository;

	// カテゴリでソート
	public List<Payment> getSortedByCategory(HouseHold houseHold) {
		List<Payment> payments = paymentRepository.findByHouseHold(houseHold);

		return payments.stream().sorted((t1, t2) -> Long.compare(t1.getCategory().getId(), t2.getCategory().getId()))
				.collect(Collectors.toList());
	}

	// 日付でソート
	public List<Payment> getSortedByDate(HouseHold houseHold) {
		List<Payment> payments = paymentRepository.findByHouseHold(houseHold);

		return payments.stream().sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate())).collect(Collectors.toList());
	}

	//金額でソート
	public List<Payment> getSortedByAmount(HouseHold houseHold) {
		List<Payment> Payments= paymentRepository.findByHouseHold(houseHold);
		
		return Payments.stream().sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
				.collect(Collectors.toList());
	}

}
