package com.example.productservice.config.converter;

import com.example.productservice.repository.util.ProductInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
@RequiredArgsConstructor
public class ProductInfoToStringConverter implements Converter<ProductInfo, String> {

  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public String convert(ProductInfo source) {
    return objectMapper.writeValueAsString(source);
  }

}
