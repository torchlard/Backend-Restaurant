package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.Tables;
import com.example.demo.repositories.TableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tables")
public class TableController {

  @Autowired
  private TableRepository repo;

  @GetMapping("/")
  public void findAll() {
    List<Tables> tables = repo.findAll();
    tables.stream().forEach(i -> System.out.println(i.toString()));
    System.out.println("------------");
  }

  @GetMapping("/available/{flag}")
  public void findByAvailable(@PathVariable boolean flag){
    List<Tables> tables = repo.findByAvailable(flag);
    tables.stream().forEach(i -> System.out.println(i.toString()));
    System.out.println("------------");
  }

  @GetMapping("/numOfSeat/{num}")
  public void findBySeat(@PathVariable int num){
    List<Tables> tables = repo.findByNumOfSeat(num);
    tables.stream().forEach(i -> System.out.println(i.toString()));
    System.out.println("------------");
  }

  @GetMapping("/numOfSeat")
  public void findByRangeSeat(
    @RequestParam(value="start", required = true) int a,
    @RequestParam(value="end", required = true) int b){
      List<Tables> tables = repo.findByNumOfSeatBetween(a,b);
      tables.stream().forEach(i -> System.out.println(i.toString()));
      System.out.println("------------");      
  }


  @PostMapping("/demo")
  public void index(){
    repo.save(new Tables(3, true));
    repo.save(new Tables(5, false));
    repo.save(new Tables(7, false));
  }

  @PostMapping("/one")
  public void addTable(
    @RequestParam(value = "seat", required = true) int seat,
    @RequestParam(value = "available", required = true) boolean flag
  ){
    repo.save(new Tables(seat, flag));
  }

  @DeleteMapping("/")
  public void deleteAll(){
    repo.deleteAllInBatch();
    System.out.println("all data deleted");
  }

  @PutMapping("/numOfSeat")
  public void setNumOfSeat(
    @RequestParam(value = "seat", required = true) int seat,
    @RequestParam(value = "id", required = true) long id
  ){
    int result = repo.setNumOfSeatBy(seat, id);
    System.out.println("set num of seat: " + result);
  }

  
}








