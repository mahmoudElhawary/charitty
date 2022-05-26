package com.ffs.charity.common.config.service.impl;

import com.ffs.charity.common.config.domain.Configuration;
import com.ffs.charity.common.config.repository.ConfigurationRepository;
import com.ffs.charity.common.config.service.ConfigurationService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {


	
  private ConfigurationRepository configurationRepository;

  @Override
  public String getAuditApiUrl() {
    return configurationRepository.findById("SAVE_AUDIT_URL").map(Configuration::getValue).orElse(null);
  }

  @Override
  public String getValue(String key) {
    return configurationRepository.findById(key).map(Configuration::getValue).orElse(null);
  }
}
