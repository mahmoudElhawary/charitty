package com.ffs.charity.common.security;

import com.ffs.dxp.common.security.JwtService;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtFilter extends com.ffs.dxp.common.security.JwtFilter {

  public JwtFilter(JwtService jwtService) {
    super(jwtService);
  }
}
