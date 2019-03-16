package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MasterOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private float price;
  private float payment;
  private float moneyReturn;

  @ManyToOne
  @JoinColumn(name = "staffId")
  private Staff staff;

  @OneToOne
  @JoinColumn(name = "tableId")
  private Tables table; 

  @Column(columnDefinition = "TIMESTAMP")
  private Date checkOutDt;


  public MasterOrder() {
  }

  public MasterOrder(float price, float payment, float moneyReturn, Staff staff, Tables table, Date checkOutDt) {
    this.price = price;
    this.payment = payment;
    this.moneyReturn = moneyReturn;
    this.staff = staff;
    this.table = table;
    this.checkOutDt = checkOutDt;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public float getPrice() {
    return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public float getPayment() {
    return this.payment;
  }

  public void setPayment(float payment) {
    this.payment = payment;
  }

  public float getMoneyReturn() {
    return this.moneyReturn;
  }

  public void setMoneyReturn(float moneyReturn) {
    this.moneyReturn = moneyReturn;
  }

  public Staff getStaff() {
    return this.staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public Tables getTable() {
    return this.table;
  }

  public void setTable(Tables table) {
    this.table = table;
  }

  public Date getCheckOutDt() {
    return this.checkOutDt;
  }

  public void setCheckOutDt(Date checkOutDt) {
    this.checkOutDt = checkOutDt;
  }

  public MasterOrder id(Long id) {
    this.id = id;
    return this;
  }

  public MasterOrder price(float price) {
    this.price = price;
    return this;
  }

  public MasterOrder payment(float payment) {
    this.payment = payment;
    return this;
  }

  public MasterOrder moneyReturn(float moneyReturn) {
    this.moneyReturn = moneyReturn;
    return this;
  }

  public MasterOrder staff(Staff staff) {
    this.staff = staff;
    return this;
  }

  public MasterOrder table(Tables table) {
    this.table = table;
    return this;
  }

  public MasterOrder checkOutDt(Date checkOutDt) {
    this.checkOutDt = checkOutDt;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", price='" + getPrice() + "'" +
      ", payment='" + getPayment() + "'" +
      ", moneyReturn='" + getMoneyReturn() + "'" +
      ", staff='" + getStaff() + "'" +
      ", table='" + getTable() + "'" +
      ", checkOutDt='" + getCheckOutDt() + "'" +
      "}";
  }
  
  
  
}









