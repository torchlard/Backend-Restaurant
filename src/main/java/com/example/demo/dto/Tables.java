package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tables {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private int numOfSeat;  
  private boolean available;
   

  public Tables() {
  }

  public Tables(int numOfSeat, boolean available) {
    this.numOfSeat = numOfSeat;
    this.available = available;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getNumOfSeat() {
    return this.numOfSeat;
  }

  public void setNumOfSeat(int numOfSeat) {
    this.numOfSeat = numOfSeat;
  }

  public boolean isAvailable() {
    return this.available;
  }

  public boolean getAvailable() {
    return this.available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", numOfSeat='" + getNumOfSeat() + "'" +
      ", available='" + isAvailable() + "'" +
      "}";
  }
  
  
  
}