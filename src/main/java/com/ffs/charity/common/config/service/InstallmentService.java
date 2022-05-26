package com.ffs.charity.common.config.service;

import java.util.List;

import com.ffs.charity.common.models.Installment;

public interface InstallmentService {

	List<Installment> findAllInstallments() ;
	
	List<Installment> saveAllInstallments(List<Installment> installments) ;
	
	Installment saveInstallment(Installment installment) ;
}
