package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Target {

	@Id
	private long target_Id;

	private int household_id;
	private int category_id;
	private int target;

}
