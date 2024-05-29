package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {
    
	@Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments> findAll() {
        return paymentsRepository.findAll();
    }

    public void save(Payments payments) {
    	paymentsRepository.save(payments);
    }

    public Optional<Payments> findById(Long id) {
        return paymentsRepository.findById(id);
    }

    public void deleteById(Long id) {
    	paymentsRepository.deleteById(id);
    }
}