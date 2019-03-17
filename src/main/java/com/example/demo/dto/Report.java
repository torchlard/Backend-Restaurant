package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Report")
public class Report {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private int income;
  private Date date;
  private int count;

  @OneToOne
  @JoinColumn(name = "staffId", insertable=false, updatable=false)
  private Staff staff;

  public Report() {
  }

  public Report(int income, Date date, int count, Staff staff) {
    this.income = income;
    this.date = date;
    this.count = count;
    this.staff = staff;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getIncome() {
    return this.income;
  }

  public void setIncome(int income) {
    this.income = income;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Staff getStaff() {
    return this.staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", income='" + getIncome() + "'" +
      ", date='" + getDate() + "'" +
      ", count='" + getCount() + "'" +
      ", staff='" + getStaff() + "'" +
      "}";
  }
  
}









