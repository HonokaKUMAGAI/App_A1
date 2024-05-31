package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HouseHold;
import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

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

	
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void save(Payment payment) {
    	paymentRepository.save(payment);
    }

    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deleteById(Long id) {
    	paymentRepository.deleteById(id);
    }

	
	//収支編集
	public void editExpense(Payment pay) {
		paymentRepository.save(pay);
	}
//  収支削除
	public void deleteExpenses(long id) {
		paymentRepository.deleteById(id);
	}
//  収支追加
	public void addExpenses(Payment pay) {
		paymentRepository.save(pay);
	}

}
