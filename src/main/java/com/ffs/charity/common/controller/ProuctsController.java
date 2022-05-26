package com.ffs.charity.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffs.charity.common.config.service.ProductsService;
import com.ffs.charity.common.models.Products;
import com.ffs.charity.common.response.ResponseMessage;

@RestController
public class ProuctsController {

	@Autowired
	private ProductsService productsService ;
	
	@GetMapping("/findAllProducts")
	public ResponseEntity<List<Products>> findAllProducts() {
		List<Products> products = productsService.findAllProducts() ;
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Products>>(products,HttpStatus.OK);
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Products> saveProduct(@RequestBody Products products) {
		if (products == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Products productsResponse = productsService.saveProduct(products) ;
		return new ResponseEntity<Products>(productsResponse,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAllProducts")
	public ResponseEntity<List<Products>> saveAllProducts(@RequestBody List<Products> products) {
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		List<Products> productsResponse = productsService.saveAllProducts(products) ;
		return new ResponseEntity<List<Products>>(productsResponse,HttpStatus.CREATED);
	}
	@GetMapping("/findProductById/{id}")
	public ResponseEntity<Products> findProductById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		Products products = productsService.findProductById(id) ;
		return new ResponseEntity<Products>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProductById/{id}")
	public ResponseEntity<ResponseMessage> deleteProductById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		productsService.deleteProduct(id) ;

		return new ResponseEntity<ResponseMessage>(new ResponseMessage("deleted"), HttpStatus.OK);
	}
	
	
}
