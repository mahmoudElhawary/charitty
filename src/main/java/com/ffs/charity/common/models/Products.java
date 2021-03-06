package com.ffs.charity.common.models;


import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String projectId ;
	private String oldId;
	private String accountingNumber;
	private String name;
	@Column(name="project_details_id")
	private Integer projectDetailsId;
	@Column(name ="project_type_id")
	private Integer projectTypeId;
	private long commiteeId;
	
	private PaymentDetails paymentDetails;
	
	@OneToMany(mappedBy = "compositeKey.project", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Donor> donorsList;
	
	private String finishingStatus;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Installment> installments;
	
	public List<Donor> getDonorsList() {
		return donorsList;
//		return Collections.EMPTY_LIST;
	}

	public void setDonorsList(List<Donor> donorsList) {
		this.donorsList = donorsList;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOldId() {
		return oldId;
	}
	public void setOldId(String oldId) {
		this.oldId = oldId;
	}
	public String getAccountingNumber() {
		return accountingNumber;
	}
	public void setAccountingNumber(String accountingNumber) {
		this.accountingNumber = accountingNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProjectDetailsId() {
		return projectDetailsId;
	}
	public void setProjectDetailsId(Integer projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Products))
			return false;
		return this.id.equals(((Products)obj).getId());
	}

	public long getCommiteeId() {
		return commiteeId;
	}

	public void setCommiteeId(long commiteeId) {
		this.commiteeId = commiteeId;
	}
	
	@AttributeOverrides({ @AttributeOverride(name = "paymentMethod", column = @Column(name = "PAYMENT_METHOD")),
			@AttributeOverride(name = "bondNumber", column = @Column(name = "BOND_NUMBER")),
			@AttributeOverride(name = "bondDate", column = @Column(name = "BOND_DATE")),
			@AttributeOverride(name = "projectValue", column = @Column(name = "PROJECT_VALUE")),
			@AttributeOverride(name = "paid", column = @Column(name = "PAID")),
			@AttributeOverride(name = "count", column = @Column(name = "COUNT")),
			@AttributeOverride(name = "discountValue", column = @Column(name = "DISCOUNT_VALUE")),
			@AttributeOverride(name = "amountAfterDiscount", column = @Column(name = "AMOUNTAFTER_DISCOUNT")),
			@AttributeOverride(name = "amountInForeignCourency", column = @Column(name = "AMOUNT_IN_FOREIGN_COURENCY")) })
	@Embedded
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	public String getFinishingStatus() {
		return finishingStatus;
	}
	
	public void setFinishingStatus(String finishingStatus) {
		this.finishingStatus = finishingStatus;
	}
	
	@JsonIgnore
	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

}
