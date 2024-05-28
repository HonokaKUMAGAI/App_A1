package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HouseHold {
	
	@Id
	private long houseHoldId;
	
	private String name;
	private long userId;
}
