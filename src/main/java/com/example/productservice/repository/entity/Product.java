package com.example.productservice.repository.entity;

import com.example.productservice.repository.util.ProductInfo;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT")
@AllArgsConstructor
@Getter
public class Product {
  @Id
  private Long id;
  private String sku;
  private String description;
  @MappedCollection(idColumn = "PRODUCT_ID")
  private Set<Price> price;
  @Column("JSON_INFO")
  private ProductInfo productInfo; // ProductInfo --> varchar(json)
  @CreatedDate
  private LocalDateTime createdAt;
  @LastModifiedDate
  private LocalDateTime lastModifiedAt;

  public static Product of(String sku, ProductInfo productInfo) {
    return new Product(null, sku, null, Set.of(), productInfo, null, null);
  }

}
