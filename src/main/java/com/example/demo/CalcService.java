package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Payments.Category;

@Service
public class CalcService {
	/*
	 * 収入と支出は、PaymentsServiceってクラスで管理することにしました。
	 * 計算系のクラスの中に入れてしまうと、総合計を出すメソッドを呼び出して何回も合計を計算しなおしてしまって効率的ではないらしい。
	 */
	@Autowired
	PaymentsService PaymentsService;

	
	/*
	 * 「支出」について、カテゴリごとの割合を算出するメソッド
	 */
	public double calculateRatioOfSpending(List<Payments> payments, Category category) {
	    // 支出の合計を取得
	    double totalSpending = PaymentsService.getTotalSpending();

	    // 特定のカテゴリの支出を取得
	    double categorySpending = PaymentsService.getCategorySpending(payments, category);
	    
	    // ゼロ除算を防ぐ
	    if (totalSpending == 0.0) {
	        System.out.println("ゼロ除算です。または支出がありません");
	        return 0.0;
	    }

	    // カテゴリの支出が全支出に対してどの割合を占めるかを計算して返す
	    return categorySpending / totalSpending * 100.0; // パーセンテージで返す
	}
	
	
	/*
	 * 「収入」について、カテゴリごとの割合を算出するメソッド
	 */
	public double calculateRatioOfIncome(List<Payments> payments, Category category) {
	    // 支出の合計を取得
	    double totalIncome = PaymentsService.getTotalIncome();

	    // 特定のカテゴリの支出を取得
	    double categoryIncome = PaymentsService.getCategorySpending(payments, category);
	    
	    // ゼロ除算を防ぐ
	    if (totalIncome == 0.0) {
	        System.out.println("ゼロ除算です。または支出がありません");
	        return 0.0;
	    }

	    // カテゴリの支出が全支出に対してどの割合を占めるかを計算して返す
	    return categoryIncome / totalIncome * 100.0; // パーセンテージで返す
	}

	

	/*
	 * カテゴリごとの目標の提案値を出すメソッド
	 */
	public double calculateSavingGoul(List<Payments> spending, Category category, double TargetMagnification) {
	    // 特定のカテゴリの支出を取得
	    double categorySpending = PaymentsService.getCategorySpending(spending, category);
	    
	    //今月のカテゴリの支出に、目標倍率をかけた、「目標金額」を返す
		return categorySpending * TargetMagnification;

	}
	
}
