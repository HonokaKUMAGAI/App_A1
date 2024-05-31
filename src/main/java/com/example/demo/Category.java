package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	
	private String name;
	
//	public enum Kind {
//		INCOME, SPENDING, OTHER //収入はINCOME、支出はSPENDING、一応その他OTHERも
//	}

//	private Kind kind;

}