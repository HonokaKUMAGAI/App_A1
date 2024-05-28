package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Target {

	@Id
	private long targetId;

	private long householdId;
	private long categoryId;
	private int targetAmounf;

}
