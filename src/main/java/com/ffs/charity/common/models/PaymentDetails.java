package com.ffs.charity.common.models;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@XmlRootElement
@Getter
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
	private String paymentMethod;
	private String bondNumber;
	private String bondDate;
	private Long projectValue;
	private Long paid;
	private Long count;
	private Long discountValue;
	private Long amountAfterDiscount;
	private Long amountInForeignCurrency;
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getBondNumber() {
		return bondNumber;
	}
	public void setBondNumber(String bondNumber) {
		this.bondNumber = bondNumber;
	}
	public String getBondDate() {
		return bondDate;
	}
	public void setBondDate(String bondDate) {
		this.bondDate = bondDate;
	}
	public Long getProjectValue() {
		return projectValue;
	}
	public void setProjectValue(Long projectValue) {
		this.projectValue = projectValue;
	}
	public Long getPaid() {
		return paid;
	}
	public void setPaid(Long paid) {
		this.paid = paid;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(Long discountValue) {
		this.discountValue = discountValue;
	}
	public Long getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(Long amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	public Long getAmountInForeignCurrency() {
		return amountInForeignCurrency;
	}
	public void setAmountInForeignCurrency(Long amountInForeignCurrency) {
		this.amountInForeignCurrency = amountInForeignCurrency;
	}
	
	
}
