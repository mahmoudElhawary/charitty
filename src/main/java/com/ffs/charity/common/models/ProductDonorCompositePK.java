package com.ffs.charity.common.models;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductDonorCompositePK implements Serializable{
	
	private long id;
	private Products project;
	
	public ProductDonorCompositePK() {
		
	}

	public ProductDonorCompositePK(long id, Products project) {
		super();
		this.id = id;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "project_id", nullable = false)
	public Products getProject() {
		return project;
	}

	public void setProject(Products project) {
		this.project = project;
	}

}
