package com.example.demo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentsId;
	
	private long householdId;
	private long categoryId;
	
	/*
	 * ちょっとカテゴリ（出費）部分で動かないので一時的にカテゴリ名を設定してます。
	 */
	private String categoryName;
	
	private long userId;
	private int amount;
	private LocalDate date;
	private String memo;
	
	/*
	 * 期間ごと系
	 */
	public enum Period{
		DAILY, MONTHLY, EVERY_YEAR}
	private Period period;
	
	/*
	 * 固定費の期間管理用
	 */
	public enum FixedCostPeriod{
		DAILY, MONTHLY, EVERY_YEAR} //, WEEKLY
	private FixedCostPeriod fixedCostPeriod;
	
	/*
	 * 収入か？支出か？分け
	 */
	public enum Kind {
	    INCOME,
	    SPENDING,
	    OTHER //収入はINCOME、支出はSPENDING、一応その他OTHERも
	}
	private Kind kind;
	
	
	/*
	 * カテゴリ分け
	 */
	public enum Category {
	    FOOD,           // 食費
	    FIXED_COSTS,    // 固定費
	    UTILITIES,      // 光熱費
	    TRANSPORT,      // 交通費
	    ENTERTAINMENT,  // 娯楽費
	    OTHER           // その他
	}
	private Category category;
	
}
