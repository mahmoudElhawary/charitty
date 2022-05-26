package com.ffs.charity.common.config.service;

import java.util.List;

import com.ffs.charity.common.models.Donor;
import com.ffs.charity.common.models.Installment;
import com.ffs.charity.common.models.PaymentDetails;
import com.ffs.charity.common.models.Products;

public interface ProductsService {

	List<Products> findAllProducts() ;
	
	List<Products> saveAllProducts(List<Products> products) ;
	
	Products saveProduct(Products products) ;
	
	Products createProject(Products products ,PaymentDetails paymentDetails ,List<Donor> donorsList ,List<Installment> installments) ;
	
	Products findProductById(Long id) ;
	
	void deleteProduct(Long id) ;
}
