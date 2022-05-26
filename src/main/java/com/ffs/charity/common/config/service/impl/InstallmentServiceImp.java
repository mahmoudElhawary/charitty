package com.ffs.charity.common.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffs.charity.common.config.repository.InstallmentRepository;
import com.ffs.charity.common.config.service.InstallmentService;
import com.ffs.charity.common.models.Installment;

@Service
public class InstallmentServiceImp implements InstallmentService {

	@Autowired
	private InstallmentRepository installmentRepository ;
	@Override
	public List<Installment> findAllInstallments() {
		return installmentRepository.findAll();
	}

	@Override
	public List<Installment> saveAllInstallments(List<Installment> installments) {
		return installmentRepository.saveAll(installments);
	}

	@Override
	public Installment saveInstallment(Installment installment) {
		return installmentRepository.save(installment);
	}

}
