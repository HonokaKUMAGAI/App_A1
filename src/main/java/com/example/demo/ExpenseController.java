package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return "index";
    }

    @GetMapping("/expense/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Expense());
        return "expenseForm";
    }

    @PostMapping("/expense")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.save(expense);
        return "redirect:/";
    }

    @GetMapping("/expense/edit/{id}")
    public String editExpense(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", expenseService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid expense Id:" + id)));
        return "expenseForm";
    }

    @GetMapping("/expense/delete/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteById(id);
        return "redirect:/";
    }
    
    
}
