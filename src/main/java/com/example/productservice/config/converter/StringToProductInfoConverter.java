package com.example.productservice.config.converter;

import com.example.productservice.repository.util.ProductInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
@RequiredArgsConstructor
public class StringToProductInfoConverter implements Converter<String, ProductInfo> {

  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public ProductInfo convert(String source) {
    return objectMapper.readValue(source.getBytes(StandardCharsets.UTF_8), ProductInfo.class);
  }
}
