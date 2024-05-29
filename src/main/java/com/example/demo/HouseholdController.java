package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HouseholdController {
	
    @Autowired
    private HouseholdService householdService;
    
    @Autowired
    private MyService myService;
    
    @Autowired
    private PaymentsService paymentsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("payments", householdService.findAll());
        return "index";
    }

    @GetMapping("/payments/new")
    public String newExpense(Model model) {
        model.addAttribute("payments", new Payments());
        return "paymentsForm";
    }

//    @PostMapping("/payments")
//    public String saveExpense(@ModelAttribute Payments payments) {
//    	myService.save(payments);
//        return "redirect:/";
//    }
    
    @PostMapping("/payments")
    public String saveExpense(@ModelAttribute Payments payments) {
    	householdService.save(payments);
        return "redirect:/";
    }

    @GetMapping("/payments/edit/{paymentsId}")
    public String editExpense(@PathVariable("paymentsId") Long id, Model model) {
        model.addAttribute("payments", householdService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paymentsId:" + id)));
        return "paymentsForm";
    }

    @GetMapping("/payments/delete/{paymentsId}")
    public String deleteExpense(@PathVariable("paymentsId") Long id) {
    	householdService.deleteById(id);
        return "redirect:/";
    }
    
    
}