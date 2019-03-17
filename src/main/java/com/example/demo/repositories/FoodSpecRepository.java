package com.example.demo.repositories;

import java.util.List;

import com.example.demo.Constant.Category;
import com.example.demo.dto.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FoodSpecRepository extends
  JpaRepository<Food,Long>, JpaSpecificationExecutor<Food> {
    List<Food> findByCategory(Category c);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update food set food_name = ?1 where id = ?2" ) // update food set ?1 where id = ?2
    public int setDynamic(String name, long id);
    
  }






