package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="household_id", referencedColumnName="id")
	private HouseHold houseHold;
	
	@ManyToOne
	@JoinColumn(name="category_id", referencedColumnName="id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="registratioin_user_id", referencedColumnName="id")
	private User user;
	
	private int amount;
	private LocalDate date;
	private String memo;
	
	public enum Kind {
		INCOME, SPENDING
	}
	private Kind kind;

}
