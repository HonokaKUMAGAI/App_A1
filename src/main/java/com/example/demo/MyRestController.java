package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.kakeibo.entity.Kakeibo;
//import com.example.kakeibo.service.KakeiboService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyRestController {
    @Autowired
    MyService service;
        
    @GetMapping("/api/kakeibo")
    public List<Payments> getAllKakeibo(@RequestParam(required = false) List<Category> categories) {
//        if (categories == null || categories.isEmpty()) {
            return service.findAll();
//        } else {
//            return service.getKakeiboByCategories(categories);
//        }
    }
    
//    家計簿データ追加処理
    @PostMapping("/payments/new")
    public Payments addExpense(@RequestBody Payments kakeibo) {
        return service.save(kakeibo);
    }
}