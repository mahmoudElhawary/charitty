package com.ffs.charity.common.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffs.charity.common.models.Installment;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {

}
