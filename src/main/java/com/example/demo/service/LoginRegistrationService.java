package com.example.demo.service;

import com.example.demo.LoginMessage;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;

public interface LoginRegistrationService {
	String registrationUser(UserDto userDto);
	LoginMessage loginUser(LoginDto loginDto);
}
