package com.example.demo;

import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Budget.Category;
import com.example.demo.Budget.Kind;

/*
 * このBudgetManagerクラスでは、収入や支出の管理、合計の計算を管理します。CalcServiceは計算サービスを提供するものとします。
 */
@Service
public class BudgetManager {
	
	@Autowired
	MyService service;
	
	
	/*
	 * 「収入」の合計を出します
	 */
	public double getTotalIncome(List<Budget> _incomes) {
        double totalIncome = 0.0;
        for (Budget income : _incomes) {
            if (income.getKind() == Kind.INCOME) {
                totalIncome += income.getAmount();
            }
        }
        return totalIncome;
    }

	/*
	 * 「支出」の合計を出します
	 */
    public double getTotalSpending(List<Budget> _spending) {
        double totalSpending = 0.0;
        for (Budget spending : _spending) {
            if (spending.getKind() == Kind.SPENDING) {
                totalSpending += spending.getAmount();
            }
        }
        return totalSpending;
    }
    
    
    /*
     * 川村さんが書いてくれたええ感じのコードの部分はじめ
     */
//  //Income(収入)の総合計金額を出すメソッド
//  	public double getTotalIncome() {
//  		double totalIncome = 0.0;
//  		List<Budget> list=service.getAllByKind(Kind.INCOME, 0);
//  		for (Budget entry : list) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
//  			if (entry.getKind() == Kind.INCOME) {
//  				totalIncome += entry.getAmount();
//  			}
//  		}
//  		return totalIncome;
//  	}
//
//  	//Expense(支出)の総合計金額を出すメソッド
//  	public double getTotalSpending() {
//  		double totalSpending = 0.0;
//  		List<Budget> list=service.getAllByKind(Kind.SPENDING,0);
//  		for (Budget entry : list) {//【要変数名すり合わせ】ここでは、収支の金額たち（配列）をExpensesListとしています。
//  			if (entry.getKind() == Kind.SPENDING) {
//  				totalSpending += entry.getAmount();
//  			}
//  		}
//  		return totalSpending;
//  	}
    /*
     * 川村さんが書いてくれたええ感じのコードの部分おわり
     */
  	
    
    /*
     * 特定のカテゴリの支出合計を出します
     */
    public double getCategorySpending(List<Budget> spending, Category category) {
        double categorySpending = 0.0;
        for (Budget spending_C : spending) {
            if (spending_C.getCategory().equals(category)) {
                categorySpending += spending_C.getAmount();
            }
        }
        return categorySpending;
    }
    
    /*
     * 特定の期間内の収入合計を出します
     */
    public double getPeriodSpending(List<Budget> spending, Period period) {
        double periodSpending = 0.0;
        for (Budget spending_P : spending) {
            if (spending_P.getPeriod().equals(period)) {
            	periodSpending += spending_P.getAmount();
            }
        }
        return periodSpending;
    }
}
