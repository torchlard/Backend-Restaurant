package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

enum Role {
  Administrator, Waiter, Manager, Cook
}

enum Gender {
  M, F
}

@Entity
public class Staff {
  // @Id: recognize as object's id
  // id should be auto generated
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  private float age;
  private String username;
  private String password;
  private int contactNumber;

  @Enumerated(EnumType.STRING)
  private Role position;
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToMany
  @JoinColumn(name = "staffId")
  private List<Report> reports;

  public Staff() {
  }

  public Staff(String firstName, String lastName, float age, String username, String password, int contactNumber, Role position, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.username = username;
    this.password = password;
    this.contactNumber = contactNumber;
    this.position = position;
    this.gender = gender;
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public float getAge() {
    return this.age;
  }

  public void setAge(float age) {
    this.age = age;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getContactNumber() {
    return this.contactNumber;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  public Role getPosition() {
    return this.position;
  }

  public void setPosition(Role position) {
    this.position = position;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", firstName='" + getFirstName() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", age='" + getAge() + "'" +
      ", username='" + getUsername() + "'" +
      ", password='" + getPassword() + "'" +
      ", contactNumber='" + getContactNumber() + "'" +
      ", position='" + getPosition() + "'" +
      ", gender='" + getGender() + "'" +
      "}";
  }



}




















