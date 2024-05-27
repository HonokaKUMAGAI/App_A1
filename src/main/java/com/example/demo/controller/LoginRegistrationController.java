package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoginMessage;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginRegistrationService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/user")
public class LoginRegistrationController {

	@Autowired
	private LoginRegistrationService loginRegistrationService;
	
	// ユーザ登録
	@PostMapping(path="/registration")
	public String registrationUser(@RequestBody UserDto userDto) {
		String id = loginRegistrationService.registrationUser(userDto);
		return id;
	}
	
	// ログイン
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
		LoginMessage loginResponse = loginRegistrationService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}
	
}
