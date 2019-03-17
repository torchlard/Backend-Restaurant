package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import com.example.demo.Constant.Category;
import com.example.demo.Constant.PageableConfig;
import com.example.demo.dto.Food;
import com.example.demo.repositories.FoodRepository;
import com.example.demo.repositories.FoodSpecRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/food")
public class FoodController {

  // @Autowired
  // private FoodRepository repo;
  @Autowired
  private FoodSpecRepository repo;

  @GetMapping("/category/{c}")
  public void findByCategory(@PathVariable("c") Category c){
    System.out.println(c);
    List<Food> food = repo.findByCategory(c);
    food.stream().forEach(i -> System.out.println(i.toString()));
    System.out.println("-----------");
  }

  @GetMapping("/composite")
  public void findByCategoryAndName(
    @RequestParam(value = "category", required = false) Category category,
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "priceL", required = false, defaultValue = "-1" ) float priceL,
    @RequestParam(value = "priceH", required = false, defaultValue = "-1") float priceH,
    @RequestParam(value = "quantityL", required = false, defaultValue = "-1") int quantityL,
    @RequestParam(value = "quantityH", required = false, defaultValue = "-1") int quantityH
  ) {
    Specification<Food> spec = 
       (root, query, cb) -> {
         List<Predicate> predicatesList = new ArrayList<>();

        //  System.out.println(category+","+name+","+priceL+","+priceH+","+quantityL+","+quantityH );
         if (category != null) {
           predicatesList.add(cb.equal(root.get("category"), category ));
         }
         if (name != null){
           predicatesList.add(cb.like(root.get("foodName"), "%"+name+"%" ));
         }
         if (priceL >= 0) {
           predicatesList.add(cb.ge(root.get("price"), priceL ));
          }
         if (priceH >= 0) {
           predicatesList.add(cb.le(root.get("price"), priceH ));
         }
         if (quantityL >= 0) {
           predicatesList.add(cb.ge(root.get("quantity"), quantityL));
         }
         if (quantityH >= 0) {
           predicatesList.add(cb.le(root.get("quantity"), quantityH));
         }
        
         query.where(cb.and(predicatesList.toArray(new Predicate[predicatesList.size()])));
         return query.getRestriction();
      };

    
    int pageNo = 0;
    Pageable pageable = PageRequest.of(pageNo, PageableConfig.pageSize, new Sort(Direction.ASC, "foodName") );
    Page<Food> food = repo.findAll(spec, pageable );
    int pageTotal = food.getTotalPages();
    
    // List<Food> food = repo.findAll(spec );
    while (pageNo < pageTotal){
      System.out.println("Page: " + pageNo+1);
      food.stream().forEach(i -> System.out.println(i.toString()));
      System.out.println("-----------");

      if (pageNo == pageTotal-1){
        return;
      }
      pageNo += 1;
      pageable = PageRequest.of(pageNo, PageableConfig.pageSize, new Sort(Direction.ASC, "foodName") );
      food = repo.findAll(spec, pageable );
    }

  }


  @PostMapping("/composite")
  public void setDynamic(
    @RequestParam(value = "category", required = false) Category category,
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "price", required = false, defaultValue = "-1") float price,
    @RequestParam(value = "quantity", required = false, defaultValue = "-1") int quantity,
    @RequestParam(value = "id", required = true) long id
  ) {

    List<String> sqlList = new ArrayList<>();
    if (category != null) sqlList.add("category = '"+category+"'");
    if (name != null) sqlList.add("food_name='"+name+"'");
    if (price >= 0) sqlList.add("price="+price);
    if (quantity >= 0) sqlList.add("quantity="+quantity);

    int result = repo.setDynamic(name, id);
    System.out.println("set dynamic result: " + result);

    // if (sqlList.size() > 0){
    //   String sql = sqlList.stream().collect(Collectors.joining(", ") );
    //   String sql2 = "update food set" + sql + "where id =" + id;
    //   System.out.println(sql2);
  
    //   int result = repo.setDynamic(sql);
    //   System.out.println("set dynamic result: " + result);
    // }
    
  }
      
  
  
  
}













