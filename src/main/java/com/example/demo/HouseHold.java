package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HouseHold {
	
	@Id
	private int id;
	private String name;
	private String user_id;
}
