package com.example.productservice.repository.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductInfo {

  private String fechaDeCreacion;
  private String fechaDeVencimiento;
  private int codigoProveedor;

}
