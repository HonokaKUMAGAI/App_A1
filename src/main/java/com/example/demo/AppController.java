package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Autowired
	CalcService calcService;

	@GetMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
}
