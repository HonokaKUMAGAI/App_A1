package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Expenses.Kind;

@Service
public class CalcService {

	@Autowired
	CalcRepository calcRepository;

	public CalcService(CalcRepository calcRepository) {
		this.calcRepository = calcRepository;
	}

	//Income(収入)の総合計金額を出すメソッド
	public double getTotalIncome() {
		double totalIncome = 0.0;
		for (Expenses entry : ExpensesList) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
			if (entry.getKind() == Kind.INCOME) {
				totalIncome += entry.getAmount();
			}
		}
		return totalIncome;
	}

	//Expense(支出)の総合計金額を出すメソッド
	public double getTotalSpending() {
		double totalSpending = 0.0;
		for (Expenses entry : ExpensesList) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
			if (entry.getKind() == Kind.SPENDING) {
				totalSpending += entry.getAmount();
			}
		}
		return totalSpending;
	}
	
	
	
}
