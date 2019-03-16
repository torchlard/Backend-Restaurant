package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.Constant.Category;

@Entity
public class Food {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String foodName;
  private float price;
  private int quantity;  

  @Enumerated(EnumType.STRING)  
  private Category category;


  public Food() {
  }

  public Food(String foodName, float price, int quantity, Category category) {
    this.foodName = foodName;
    this.price = price;
    this.quantity = quantity;
    this.category = category;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFoodName() {
    return this.foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public float getPrice() {
    return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", foodName='" + getFoodName() + "'" +
      ", price='" + getPrice() + "'" +
      ", quantity='" + getQuantity() + "'" +
      ", category='" + getCategory() + "'" +
      "}";
  }
  
  

}

















