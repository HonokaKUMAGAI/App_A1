package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Assessment {

	@Autowired
	TargetRepository targetRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	MyService service;

//	目標金額の合計
	private int totalTargetAmount() {

		int total = 0;
		List<Category> cate = categoryRepository.findAll/*ByKind*/(/*Category.Kind.SPENDING*/);
		List<Target> targetList = new ArrayList<>();
		for (Category category : cate) {
			List<Target>targets=targetRepository.findByCategoryId(category.getCategoryId());
			for(Target target:targets) {
				targetList.add(target);
			}
		}
		for (Target target : targetList) {
			total += target.getTargetAmounf();
		}
		return total;
	}

	/*
	 * 「収入」の合計を出します
	 */
//	public double getTotalIncome() {
//		double totalIncome = 0.0;
//		List<Payments> list = service.getAllByKind(Kind.INCOME, 0,0);
//		for (Payments entry : list) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
//			totalIncome += entry.getAmount();
//		}
//		return totalIncome;
//	}

	/*
	 * 「支出」の合計を出します
	 */
//	private double getTotalSpending() {
//		double totalSpending = 0.0;
//		List<Payments> list = service.getAllByKind(Kind.SPENDING, 0,0);
//		for (Payments entry : list) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
//			totalSpending += entry.getAmount();
//		}
//		return totalSpending;
//	}

	//目標達成しているか
//	public boolean condition() {
//
//		boolean condition = false;
//		if (totalTargetAmount() >= getTotalSpending()) {
//			condition = true;
//		}
//		return condition;
//	}

	/*
	 * 特定のカテゴリの支出合計を出します
	 */
//	public double getCategorySpending(List<Payments> spending, Category category) {
//		double categorySpending = 0.0;
//		for (Payments spending_C : spending) {
//			if (spending_C.getCategoryId() == category.getCategoryId()) {
//				categorySpending += spending_C.getAmount();
//			}
//		}
//		return categorySpending;
//	}
//
//	/*
//	 * 特定の期間内の収入合計を出します
//	 */
//	public double getPeriodSpending(List<Payments> spending, Period period) {
//		double periodSpending = 0.0;
//		for (Payments spending_P : spending) {
//			if (spending_P.getPeriod().equals(period)) {
//				periodSpending += spending_P.getAmount();
//			}
//		}
//		return periodSpending;
//	}
//
//	/*
//	 * 先日、先週、昨年の出費
//	 */
//	public double getTotalForPeriod_pre(List<Payments> payments, Period period, Kind kind) {
//		LocalDate today = LocalDate.now();
//		double total = 0.0;
//
//		switch (period) {
//		case DAILY:
//			total = getDailyTotal(payments, today.minusDays(1), kind);
//			break;
//		case MONTHLY:
//			total = getMonthlyTotal(payments, today.minusMonths(1), kind);
//			break;
//		case EVERY_YEAR:
//			total = getYearlyTotal(payments, today.minusYears(1), kind);
//			break;
//		default:
//			// 期間がサポートされていない場合は0を返す
//			break;
//		}
//
//		return total;
//	}
//
//	public double getTotalForPeriod(List<Payments> payments, Period period, Kind kind) {
//		LocalDate today = LocalDate.now();
//		double total = 0.0;
//
//		switch (period) {
//		case DAILY:
//			total = getDailyTotal(payments, today, kind);
//			break;
//		case MONTHLY:
//			total = getMonthlyTotal(payments, today, kind);
//			break;
//		case EVERY_YEAR:
//			total = getYearlyTotal(payments, today, kind);
//			break;
//		default:
//			// 期間がサポートされていない場合は0を返す
//			break;
//		}
//
//		return total;
//	}
//
//	private double getDailyTotal(List<Payments> payments, LocalDate date, Kind kind) {
//		return payments.stream()
//				.filter(payment -> payment.getDate().isEqual(date) && payment.getKind() == kind)
//				.mapToDouble(Payments::getAmount)
//				.sum();
//	}
//
//	private double getMonthlyTotal(List<Payments> payments, LocalDate date, Kind kind) {
//		return payments.stream()
//				.filter(payment -> payment.getDate().getYear() == date.getYear() &&
//						payment.getDate().getMonth() == date.getMonth() &&
//						payment.getKind() == kind)
//				.mapToDouble(Payments::getAmount)
//				.sum();
//	}
//
//	private double getYearlyTotal(List<Payments> payments, LocalDate date, Kind kind) {
//		return payments.stream()
//				.filter(payment -> payment.getDate().getYear() == date.getYear() &&
//						payment.getKind() == kind)
//				.mapToDouble(Payments::getAmount)
//				.sum();
//	}

}
