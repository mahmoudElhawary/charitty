package com.ffs.charity.common.config.repository;

import com.ffs.charity.common.config.domain.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, String> {
	
}
