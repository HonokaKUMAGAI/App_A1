package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Budget.Category;

@Service
public class CalcService {

	/*
	 * 収入と支出は、BudgetManagerってクラスで管理することにしました。
	 * 計算系のクラスの中に入れてしまうと、総合計を出すメソッドを呼び出して何回も合計を計算しなおしてしまって効率的ではないらしい。
	 */
	@Autowired
	PaymentsRepository paymentsRepository;
	
	@Autowired
	PaymentsService paymentsService;

	
	/*
	 * カテゴリごとの割合を算出するメソッド
	 */
	public double calculateRatioOfBudget(List<Budget> spending, Category category) {
	    // 支出の合計を取得
	    double totalSpending = paymentsService.getTotalSpending();

	    // 特定のカテゴリの支出を取得
	    double categorySpending = paymentsService.getCategorySpending(spending, category);
	    
	    // ゼロ除算を防ぐ
	    if (totalSpending == 0.0) {
	        System.out.println("ゼロ除算です。または支出がありません");
	        return 0.0;
	    }

	    // カテゴリの支出が全支出に対してどの割合を占めるかを計算して返す
	    return categorySpending / totalSpending * 100.0; // パーセンテージで返す
	}


	
	/*
	 * カテゴリごとの目標の提案値を出すメソッド
	 * TargetMagnificationは、0.5かけとか0.8かけとか、倍率を想定。
	 */
	public double calculateSavingGoul(List<Budget> spending, Category category, double TargetMagnification) {
	    // 特定のカテゴリの支出を取得
	    double categorySpending = paymentsService.getCategorySpending(spending, category);
	    
	    //今月のカテゴリの支出に、目標倍率をかけた、「目標金額」を返す
		return categorySpending * TargetMagnification;

	}
	
}
