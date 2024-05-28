package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
    private CategoryRepository categoryRepository;

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
    
    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }
    
    @PostMapping("/categories")
    public String addCategory(@RequestParam("name") String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/categories";
    }
    
    // カテゴリ削除処理
    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable("id") Long id) { // 引数に名前を指定する
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        
        category.setDeleted(true); // 削除フラグを設定

        categoryRepository.save(category); // データベースに保存

        return "redirect:/categories"; // カテゴリ一覧ページにリダイレクト
    }
    
    
}
