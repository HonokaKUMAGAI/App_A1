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
	private long expensesId;
	
	private long householdId;
	private long categoryId;
	private long userId;
	private int amount;
	private LocalDate date;
	private String memo;

	private enum Roop {
		daily, weekly, monthly, everyyear
	}
	
	private Roop roop;

	public enum Kind {
		INCOME, SPENDING, OTHER //収入はINCOME、支出はSPENDING、一応その他OTHERも
	}

	private Kind kind;

//	public Kind getKind() {
//		return this.kind;
//	}
//
//	public void setKind(Kind kind) {
//		this.kind = kind;
//	}
//
//	public boolean isIncome() {
//		return this.kind == Kind.INCOME;
//	}
//
//	public boolean isSpending() {
//		return this.kind == Kind.SPENDING;
//	}
//
//	public LocalDate getDate() {
//		// TODO 自動生成されたメソッド・スタブ
//		return this.date;
//	}

}