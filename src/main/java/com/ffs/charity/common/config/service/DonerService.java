package com.ffs.charity.common.config.service;

import java.util.List;

import com.ffs.charity.common.models.Donor;

public interface DonerService {

	List<Donor> findAllDonors() ;
	
	List<Donor> saveAllDonors(List<Donor> donors) ;
	
	Donor saveDonor(Donor donor) ;
}
