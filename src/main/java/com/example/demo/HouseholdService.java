package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdService {
    
	@Autowired
    private HouseholdRepository householdRepository;

    public List<Household> findAll() {
        return householdRepository.findAll();
    }

    public void save(Household expense) {
    	householdRepository.save(expense);
    }

    public Optional<Household> findById(Long id) {
        return householdRepository.findById(id);
    }

    public void deleteById(Long id) {
    	householdRepository.deleteById(id);
    }
}