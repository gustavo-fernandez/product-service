package com.example.productservice.config.audit;

import com.example.productservice.service.impl.AuthenticatedUserContext;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.ofNullable(AuthenticatedUserContext.getCurrentUser());
  }

}
