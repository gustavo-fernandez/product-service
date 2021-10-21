package com.example.productservice.config;

import com.example.productservice.config.converter.ProductInfoToStringConverter;
import com.example.productservice.config.converter.StringToProductInfoConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "com.example.productservice.repository")
@EnableJdbcAuditing
public class SpringDataJdbcConfiguration extends AbstractJdbcConfiguration {

  @Autowired
  private ObjectMapper objectMapper;

  @Bean
  @Override
  public JdbcCustomConversions jdbcCustomConversions() {
    return new JdbcCustomConversions(List.of(
      new ProductInfoToStringConverter(objectMapper),
      new StringToProductInfoConverter(objectMapper)
    ));
  }

}
