package com.example.productservice.service.impl;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class AuthenticatedUserContext {

  private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();

  public static void setUsername(String username) {
    CURRENT_USER.set(username);
  }

  public static String getCurrentUser() {
    return CURRENT_USER.get();
  }

}
