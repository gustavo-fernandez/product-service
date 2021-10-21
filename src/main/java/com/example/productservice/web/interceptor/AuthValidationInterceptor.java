package com.example.productservice.web.interceptor;

import com.example.productservice.common.annotation.JwtAction;
import com.example.productservice.delegate.spi.AuthServerClient;
import com.example.productservice.service.impl.AuthenticatedUserContext;
import com.example.productservice.web.exception.UnauthenticatedException;
import com.example.productservice.web.exception.UnauthorizedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthValidationInterceptor implements HandlerInterceptor {

  private final AuthServerClient authServerClient;
  private final ObjectMapper objectMapper;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      Method method = handlerMethod.getMethod();
      JwtAction jwtAction = method.getAnnotation(JwtAction.class);
      if (jwtAction == null) {
        return true;
      }
      String authorization = request.getHeader("Authorization");
      if (authorization == null || !authorization.startsWith("Bearer ")) {
        throw new UnauthenticatedException();
      }
      String jwt = authorization.substring(7);
      log.info("Token: {} | Action: {}", jwt, jwtAction.value());
      boolean isAuthorized = authServerClient.validateToken(jwt, jwtAction.value());
      if (!isAuthorized) {
        throw new UnauthorizedException();
      }
      String username = getSubjectFromJwt(jwt);
      log.info("Logged in user: {}", username);
      AuthenticatedUserContext.setUsername(username);
    }
    return true;
  }

  @SneakyThrows
  private String getSubjectFromJwt(String jwt) {
    var parts = jwt.split("\\.");
    var jwtBody = parts[1];
    byte[] plainJwtBody = Base64.getDecoder().decode(jwtBody);
    return objectMapper.readValue(plainJwtBody, PlainJwtBody.class).getSub();
  }

  @Getter
  @Setter
  private static class PlainJwtBody {
    private String sub;
  }

}
