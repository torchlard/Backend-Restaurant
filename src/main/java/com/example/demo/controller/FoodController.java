package com.example.demo.controller;

import java.util.List;

import com.example.demo.Constant.Category;
import com.example.demo.dto.Food;
import com.example.demo.repositories.FoodRepository;
import com.example.demo.repositories.FoodSpecRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/food")
public class FoodController {

  @Autowired
  private FoodRepository repo;
  @Autowired
  private FoodSpecRepository sepo;

  @GetMapping("/category/{c}")
  public void findByCategory(@PathVariable("c") Category c){
    List<Food> food = repo.findByCategory(c);
    food.stream().forEach(i -> System.out.println(i.toString()));
    System.out.println("-----------");
  }

  @GetMapping("/composite")
  public void findByCategoryAndName(
    @RequestParam(value = "category", required = false) Category category,
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "priceL", required = false) float priceL,
    @RequestParam(value = "priceH", required = false) float priceH,
    @RequestParam(value = "quantity", required = false) float quantity
  ) {
    Specification<Food> spec = 
       (root, query, cb) -> {
          return cb.equal(root.get(name), "a");
      };

    sepo.findAll(spec);
  }
      
  
  
  
}













