package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO )
  private Long id;

  private int quantity;

  @ManyToOne
  @JoinColumn(name = "masterOrderId")
  private MasterOrder masterOrder;

  @OneToOne
  private Food food;

  public Orders() {
  }

  public Orders(int quantity, MasterOrder masterOrder) {
    this.quantity = quantity;
    this.masterOrder = masterOrder;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public MasterOrder getMasterOrder() {
    return this.masterOrder;
  }

  public void setMasterOrder(MasterOrder masterOrder) {
    this.masterOrder = masterOrder;
  }

  public Orders id(Long id) {
    this.id = id;
    return this;
  }

  public Orders quantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public Orders masterOrder(MasterOrder masterOrder) {
    this.masterOrder = masterOrder;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", quantity='" + getQuantity() + "'" +
      ", masterOrder='" + getMasterOrder() + "'" +
      "}";
  }

  
}

















