package com.ffs.charity.common.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffs.charity.common.config.repository.DonerRepository;
import com.ffs.charity.common.config.service.DonerService;
import com.ffs.charity.common.models.Donor;

@Service
public class DonerServiceImpl implements DonerService {

	@Autowired
	private DonerRepository donerRepository ;
	
	@Override
	public List<Donor> findAllDonors() {
		return donerRepository.findAll();
	}

	@Override
	public List<Donor> saveAllDonors(List<Donor> donors) {
		return donerRepository.saveAll(donors);
	}

	@Override
	public Donor saveDonor(Donor donor) {
		return donerRepository.save(donor);
	}

}
