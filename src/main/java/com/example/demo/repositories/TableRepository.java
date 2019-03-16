package com.example.demo.repositories;

import java.util.List;

import com.example.demo.dto.Tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TableRepository extends JpaRepository<Tables,Long> {
  public List<Tables> findByAvailable(boolean flag);
  public List<Tables> findByNumOfSeat(int i);
  public List<Tables> findByNumOfSeatBetween(int a, int b);

  @Modifying
  @Transactional
  @Query("update Tables t set t.numOfSeat=:s where t.id=:i")
  public int setNumOfSeatBy(@Param("s") int seat, @Param("i") long id);

}












