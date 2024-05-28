package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

	@GetMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
	
	@Autowired
	MyService service;
	
	private Payments.Kind kind=Payments.Kind.SPENDING;
	
	private int user=0;
	
	@GetMapping("/home")
	public String getPaymentsList(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<Payments> pays;
		if (sort != null) {
			switch (sort) {
			case "category":
				pays = service.getKindSortedByCategory(kind,user);
				break;
			case "date":
				pays = service.getKindSortedByDate(kind,user);
				break;
			case "amount":
				pays = service.getKindSortedByAmount(kind,user);
				break;
			default:
				pays = service.getAllByKind(kind,user);
				break;
			}
		} else {
			pays = service.getAllByKind(kind,user);
		}
		model.addAttribute("pays", pays);
		return "paymentsList";
	}
	
	 @PostMapping("/button")
	    public String handleButton(@RequestParam(name="input", required=false, defaultValue="") String input, Model model) {
	        user=1;
	        model.addAttribute("message", "ボタンが押されました。入力値: " + input);
	        return "result";
	    }
}
