package com.example.demo.repositories;

import java.util.List;

import com.example.demo.Constant.Category;
import com.example.demo.dto.Food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
  List<Food> findByCategory(Category c);
  List<Food> findByFoodName(String name);
  List<Food> findByPrice(float p);
  List<Food> findByQuantity(int quantity);

}









