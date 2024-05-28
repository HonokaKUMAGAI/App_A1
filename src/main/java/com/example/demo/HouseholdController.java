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

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("expenses", householdService.findAll());
        return "index";
    }

    @GetMapping("/payments/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Payments());
        return "expenseForm";
    }

    @PostMapping("/expense")
    public String saveExpense(@ModelAttribute Household household) {
    	householdService.save(household);
        return "redirect:/";
    }

    @GetMapping("/expense/edit/{paymentsId}")
    public String editExpense(@PathVariable("paymentsId") Long id, Model model) {
        model.addAttribute("expense", householdService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paymentsId:" + id)));
        return "expenseForm";
    }

    @GetMapping("/expense/delete/{paymentsId}")
    public String deleteExpense(@PathVariable("paymentsId") Long id) {
    	householdService.deleteById(id);
        return "redirect:/";
    }
    
    
}