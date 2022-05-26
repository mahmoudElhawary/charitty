package com.ffs.charity.common.config.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffs.charity.common.config.repository.ProductsRepository;
import com.ffs.charity.common.config.service.ProductsService;
import com.ffs.charity.common.models.Donor;
import com.ffs.charity.common.models.Installment;
import com.ffs.charity.common.models.PaymentDetails;
import com.ffs.charity.common.models.Products;

@Service
//@Transactional
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public List<Products> findAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public List<Products> saveAllProducts(List<Products> products) {
		return productsRepository.saveAll(products);
	}

	@Override
	public Products saveProduct(Products products) {
		return productsRepository.save(products);
	}

	@Override
	public Products findProductById(Long id) {
		return productsRepository.getById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		productsRepository.deleteById(id);
	}

	@Override
	public Products createProject(Products products, PaymentDetails paymentDetails, List<Donor> donorsList,
			List<Installment> installments) {
		products.setPaymentDetails(paymentDetails);
		products.setDonorsList(donorsList);
		products.setInstallments(installments);
		return productsRepository.save(products);
	}

}
