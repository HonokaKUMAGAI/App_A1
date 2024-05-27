package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * ToDo MEMO:
 * ログインに使う
 * 	usernameParameter
 * 　					を設定する
 */
/**
 * ログイン関連のコンフィグ
 * 
 * author: k.yamashita
 * 
 * ↓変更したら自分の名前に変えてね
 * Last update by : k.yamashita
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
// thymleaf使うときのやつ供養
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//		
//		// ログイン部分の設定
//		.formLogin(login -> login
//				.loginPage("/login")						//ログイン画面
//				.loginProcessingUrl("/login")
//				.usernameParameter("ログインID")		//ログイン用のID　IDとかメールアドレス
//				.passwordParameter("password")	//ログイン用のパスワード
//				.defaultSuccessUrl("/index")		//ログイン成功後に遷移するURL だいたいTOPのURL
//				.failureUrl("/login?error")			//ログイン失敗時
//				.permitAll()
//		)
//		
//		// 誰でもアクセスできる部分の設定
//		.authorizeHttpRequests(authz -> authz
//				.requestMatchers("/css/**",
//												 "/images/**",
//												 "/js/**").permitAll()
//				.requestMatchers("registration").permitAll()
//		)
//		
//		// ログアウト部分の設定
//		.logout(logout -> logout
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutUrl("logout")
//				.logoutSuccessUrl("/login")
//		);
//		
//		return http.build();
//	}
	
	
	// パスワードハッシュ化のやつ
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
