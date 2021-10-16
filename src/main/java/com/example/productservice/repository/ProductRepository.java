package com.example.productservice.repository;

import com.example.productservice.repository.entity.Product;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// En runtime se crea un "ProductRepositoryImpl" que tiene los métodos de Spring Data JDBC
public interface ProductRepository extends CrudRepository<Product, Long> {

  Optional<Product> findBySku(String sku);

  @Modifying
  @Query("UPDATE product SET description = :newDescription WHERE sku = :sku")
  boolean updateDescriptionBySku(@Param("newDescription") String description, String sku);

}