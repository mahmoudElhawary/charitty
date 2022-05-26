package com.ffs.charity.common.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffs.charity.common.models.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}
