package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GroupUser {
	
	@Id
	private long groupId;
	
	private long userId;

	private enum Role {
		ADMIN, VIEWER, INVITED
	}
	private Role role;
	
}