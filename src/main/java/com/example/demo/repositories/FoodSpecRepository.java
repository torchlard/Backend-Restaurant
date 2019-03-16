package com.example.demo.repositories;

import com.example.demo.dto.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FoodSpecRepository extends
  JpaRepository<Food,Long>, JpaSpecificationExecutor<Food> {
    
  }






