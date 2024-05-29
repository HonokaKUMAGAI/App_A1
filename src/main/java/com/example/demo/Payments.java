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

	public enum Period {
		DAILY, WEEKLY,MONTHLY, EVERY_YEAR
	}
	
	private Period period;

	public enum Kind {
		INCOME, SPENDING, OTHER //収入はINCOME、支出はSPENDING、一応その他OTHERも
	}

	private Kind kind;

}