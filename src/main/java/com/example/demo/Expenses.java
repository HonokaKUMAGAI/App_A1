package com.example.demo;

import lombok.Data;

@Data
public class Expenses {
	private long expenses_id;
	private int household_id;
	private int category_id;
	private int user_id;
	private int amount;
//	private datetime date;
	private String memo;
	private enum roop{
	daily,weekly,monthly,everyyear}
	
	public enum Kind {
	    INCOME,
	    SPENDING,
	    OTHER //収入はINCOME、支出はSPENDING、一応その他OTHERも
	}
	
	private Kind kind;

    public Kind getKind() {
        return this.kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public boolean isIncome() {
        return this.kind == Kind.INCOME;
    }

    public boolean isSpending() {
        return this.kind == Kind.SPENDING;
    }
}
