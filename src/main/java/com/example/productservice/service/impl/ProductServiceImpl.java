package com.example.productservice.service.impl;

import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.entity.Product;
import com.example.productservice.service.spi.ProductService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Product findProductById(Long id) {
    Optional<Product> productOptional = productRepository.findById(id);
    return productOptional.orElseThrow(() -> new RuntimeException("Product Not found"));
  }

  @Override
  public Product findBySku(String sku) {
    Optional<Product> productOptional = productRepository.findBySku(sku);
    return productOptional.orElseThrow(() -> new RuntimeException("Product Not found"));
  }

  @Override
  public boolean updateDescriptionBySku(String description, String sku) {
    return productRepository.updateDescriptionBySku(description, sku);
  }

  @Override
  public void create(Product product) {
    productRepository.save(product);
  }

}
