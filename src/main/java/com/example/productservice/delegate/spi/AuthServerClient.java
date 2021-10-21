package com.example.productservice.delegate.spi;

public interface AuthServerClient {

  Boolean validateToken(String jwt, String actionToValidate);

}
