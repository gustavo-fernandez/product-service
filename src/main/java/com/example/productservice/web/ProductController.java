package com.example.productservice.web;

import com.example.productservice.common.annotation.JwtAction;
import com.example.productservice.repository.entity.Product;
import com.example.productservice.repository.util.ProductInfo;
import com.example.productservice.service.spi.ProductService;
import com.example.productservice.web.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  @JwtAction("productos")
  public ApiResponse<Product> getProductById(@PathVariable Long id) {
    Product product = productService.findProductById(id);
    return ApiResponse.<Product>builder()
      .data(product)
      .code("A01")
      .build();
  }

  @GetMapping()
  @JwtAction("productos")
  public ApiResponse<Product> getProductById(@RequestParam String sku) {
    Product product = productService.findBySku(sku);
    return ApiResponse.<Product>builder()
      .data(product)
      .code("A01")
      .build();
  }

  @GetMapping("update")
  @JwtAction("productos")
  public ApiResponse<Boolean> updateDescriptionBySku(@RequestParam String sku, @RequestParam String description) {
    boolean isUpdated = productService.updateDescriptionBySku(description, sku);
    return ApiResponse.<Boolean>builder()
      .data(isUpdated)
      .code("A01")
      .build();
  }

  @GetMapping("create")
  @JwtAction("productos")
  public ApiResponse<Boolean> createProduct() {
    Product product = Product.of("S0006",
      new ProductInfo("2021-01-01", "2021-10-12", 19));
    productService.create(product);
    return ApiResponse.<Boolean>builder()
      .data(true)
      .code("A01")
      .build();
  }

}
