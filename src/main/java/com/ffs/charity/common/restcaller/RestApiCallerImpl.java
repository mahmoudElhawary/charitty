package com.ffs.charity.common.restcaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RestApiCallerImpl extends com.ffs.dxp.common.restcaller.RestApiCallerImpl {

  public RestApiCallerImpl(
      @Value("${rest.template.req.connection.time.out}") final int requestConnectionTimeout,
      @Value("${rest.template.read.time.out}") final int readTimeout) {
    super(requestConnectionTimeout, readTimeout);
  }
}
