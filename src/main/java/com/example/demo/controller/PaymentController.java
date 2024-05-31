package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ToPayments;
import com.example.demo.entity.Category;
import com.example.demo.entity.HouseHold;
import com.example.demo.entity.Payment;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.HouseHoldRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentController {

	private final PaymentRepository paymentRepository;
	private final CategoryRepository categoryRepository;
	private final HouseHoldRepository houseHoldRepository;

	private final PaymentService sortService;

	// ある家計簿の収支レコードを全件取得
	@GetMapping("/payments/{id}")
	@ResponseBody
	public List<Payment> getPayments(@PathVariable("id") Long household_id) {

		HouseHold household = new HouseHold();
		household.setId(household_id);
		return paymentRepository.findByHouseHold(household);
	}

	// 収支レコードの追加
	@PostMapping("/payments/new")
	public Payment createPayment(@RequestBody ToPayments toPayments) {
	    Payment payment = new Payment();

	    HouseHold houseHold = houseHoldRepository.findById(1L).orElseThrow(() -> new RuntimeException());
	    payment.setHouseHold(houseHold);

	    payment.setAmount((int) toPayments.getAmount());
	    payment.setDate(toPayments.getDate());
	    payment.setMemo(toPayments.getMemo());
	    Category category = categoryRepository.findById(Long.parseLong(toPayments.getCategoryId()))
	            .orElseThrow(() -> new RuntimeException("Category not found"));
	    payment.setCategory(category);
	    return paymentRepository.save(payment);
	}


//	@PostMapping("/payments/sort")@RequestParam("sortType") String sortType,
	@GetMapping("/payments/sort/{sortType}")
	public List<Payment> sort(@PathVariable int sortType, Model model) {
		HouseHold houseHold = houseHoldRepository.findById(1L).orElseThrow(() -> new RuntimeException());

		List<Payment> sortedPayments = null;
		switch (sortType) {
		case 0:
			// デフォルトでは追加した順に表示する
			sortedPayments = paymentRepository.findByHouseHold(houseHold);
			break;
		case 1/* "date" */:
			sortedPayments = sortService.getSortedByDate(houseHold);
			break;
		case 2/* "categoryId" */:
			sortedPayments = sortService.getSortedByCategory(houseHold);
			break;
		case 3/*"amount"*/:
			sortedPayments = sortService.getSortedByAmount(houseHold);
			break;
		}
		
		return sortedPayments;
	}

	
	/*
	 * 来月目標設定処理
	 */
	@GetMapping("/nextTarget")
    public List<Payment> getNextTargetData() {
        return paymentRepository.findAll();
    }
	
}
