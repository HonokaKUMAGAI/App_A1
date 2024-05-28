package com.example.demo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Budget {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
	
	private long expenses_id;
	private int household_id;
	private int category_id;
	private int userId;
	private int amount;
	private LocalDate date;
	private String memo;
	
	/*
	 * 期間ごと系
	 */
	public enum Period{
		DAILY, WEEKLY, MONTHLY, EVERY_YEAR}
	private Period period;
	
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
	

//    public Kind getKind() {
//        return this.kind;
//    }
//
//    public void setKind(Kind kind) {
//        this.kind = kind;
//    }
//
//    public boolean isIncome() {
//        return this.kind == Kind.INCOME;
//    }
//
//    public boolean isSpending() {
//        return this.kind == Kind.SPENDING;
//    }
}
