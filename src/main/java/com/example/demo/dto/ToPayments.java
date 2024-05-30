package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ToPayments {
    private long categoryId;
    private int amount;
    private LocalDate date;
    private String memo;
}
