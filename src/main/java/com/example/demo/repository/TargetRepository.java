package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Target;

public interface TargetRepository extends JpaRepository<Target, Long>{

}
