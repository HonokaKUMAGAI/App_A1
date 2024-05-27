package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

	@GetMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
	
	@Autowired
	MyService service;
	
	private Expenses.Kind kind=Expenses.Kind.SPENDING;
	
	private int user=0;
	
	@GetMapping("/home")
	public String getExpensesList(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<Expenses> exs;
		if (sort != null) {
			switch (sort) {
			case "category":
				exs = service.getKindSortedByCategory(kind,user);
				break;
			case "date":
				exs = service.getKindSortedByDate(kind,user);
				break;
			case "amount":
				exs = service.getKindSortedByAmount(kind,user);
				break;
			default:
				exs = service.getAllByKind(kind,user);
				break;
			}
		} else {
			exs = service.getAllByKind(kind,user);
		}
		model.addAttribute("exs", exs);
		return "expensesList";
	}
}
