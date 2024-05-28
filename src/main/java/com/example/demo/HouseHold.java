package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HouseHold {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long houseHoldId;
	
	private String name;
	private long userId;
}
