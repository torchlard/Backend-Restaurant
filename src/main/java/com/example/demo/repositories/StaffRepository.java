package com.example.demo.repositories;

import com.example.demo.dto.Staff;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
  List<Staff> findByLastName(String lastName);
  List<Staff> findByFirstName(String firstName);

}


















