package com.ffs.charity.common.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffs.charity.common.models.Donor;
import com.ffs.charity.common.models.ProductDonorCompositePK;

@Repository
public interface DonerRepository extends JpaRepository<Donor, ProductDonorCompositePK> {

}
