package com.ffs.charity.common.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.ffs.utils.DateFormatterAdapter;

import lombok.NoArgsConstructor;

@Entity
@Table(name="installment")
@XmlRootElement
@NoArgsConstructor
public class Installment {
	
	private Long id;
	private BigDecimal amount;
	private String payType;
	private Date date;
	private String docNo;
	private String notes;
	
	private Products project;
	
	public Installment(BigDecimal amount, String payType, Date date, String docNo, String notes) {
		this.amount = amount;
		this.payType = payType;
		this.date = date;
		this.docNo = docNo;
		this.notes = notes;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "amount")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@NotNull
	@Column(name = "type")
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Column(name = "date")
//	@XmlJavaTypeAdapter(DateFormatterAdapter.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "doc_no")
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@ManyToOne
	@JoinColumn(name = "project_id")
	@JsonIgnore
	@XmlTransient
	public Products getProject() {
		return project;
	}

	public void setProject(Products project) {
		this.project = project;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Installment))
			return false;
		return this.id.equals(((Installment)obj).getId());
	}

}
