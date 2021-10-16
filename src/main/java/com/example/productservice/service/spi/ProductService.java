package com.example.productservice.service.spi;

import com.example.productservice.repository.entity.Product;

public interface ProductService {

  Product findProductById(Long id);

  Product findBySku(String sku);

  boolean updateDescriptionBySku(String description, String sku);

  void create(Product product);
}
