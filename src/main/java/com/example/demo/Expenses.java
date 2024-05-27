package com.example.demo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Expenses {
	
	@Id
	private long expenses_id;
	
	private int household_id;
	private int category_id;
	private int user_id;
	private int amount;
	private LocalDate date;
	private String memo;

	private enum Roop {
		daily, weekly, monthly, everyyear
	}
	
	Roop roop;

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