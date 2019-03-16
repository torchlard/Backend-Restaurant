package com.example.demo.util;

import org.springframework.data.jpa.domain.Specification;

public final class SpecificationFactory {
  
  public static Specification likes(String attr, String value) {
    return (root, query, cb) -> cb.like(root.get(attr), "%" + value + "%");
  }

  
  
}










