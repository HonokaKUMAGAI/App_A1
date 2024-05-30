package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	private String password;
	private String username;
	private String email;
	
	public User (String _name, String _email, String _password) {
		this.username = _name;
		this.email = _email;
		this.password = _password;
	}
}