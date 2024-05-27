package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.LoginMessage;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@EnableJpaRepositories(basePackages="com.example.demo.repository")
public class LoginRegistrationServiceImpl implements LoginRegistrationService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String registrationUser(UserDto userDto) {
		User user = new User(
				userDto.getName(),
				userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword())
		);
		
		userRepository.save(user);
		return user.getName();
	}
	
	@Override
	public LoginMessage loginUser(LoginDto loginDto) {
		User user = userRepository.findByEmail(loginDto.getEmail());
		
		if( user != null ) {
			String pwd = loginDto.getPassword();
			String hashedPwd = user.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(pwd, hashedPwd);
			
			if( isPwdRight ) {
				Optional<User> userOptional = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), hashedPwd);
				
				if( userOptional.isPresent() ) {
					return new LoginMessage("Login Success", true);
				} else {
					return new LoginMessage("Login Failed", false);
				}
			} else {
				return new LoginMessage("password Not Match", false);
			}			
		} else {
			return new LoginMessage("Email not Exists", false);
		}
	}
}
