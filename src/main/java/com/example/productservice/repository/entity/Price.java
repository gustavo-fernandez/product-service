package com.example.productservice.repository.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Price {

  private String day;
  private BigDecimal price;

}
