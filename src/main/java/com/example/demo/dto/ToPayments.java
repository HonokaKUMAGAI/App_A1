package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ToPayments {
    private double amount;
    private LocalDate date;
    private String categoryId;
    private String memo;
}
