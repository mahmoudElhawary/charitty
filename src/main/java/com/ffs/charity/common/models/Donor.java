package com.ffs.charity.common.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@XmlRootElement
@Embeddable
//@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
@NoArgsConstructor
public class Donor {
	private ProductDonorCompositePK compositeKey;
	private String idNumber;
	private String donorProjectName;
	private String phoneNumber;
	
	@JsonIgnore
	@EmbeddedId 
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id"))})
	public ProductDonorCompositePK getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(ProductDonorCompositePK compositeKey) {
		this.compositeKey = compositeKey;
	}

	@Transient
	public long getId() {
		return compositeKey.getId();
	}
	
	@Transient
	public long getProjectId() {
		return compositeKey.getProject().getId();
	}

	public void setId(long id) {
		if(this.compositeKey == null) 
			this.compositeKey=new ProductDonorCompositePK();
		
			this.compositeKey.setId(id);
	}

	public String getIdNumber() {
		return idNumber;
	}
	

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDonorProjectName() {
		return donorProjectName;
	}

	public void setDonorProjectName(String donorProjectName) {
		this.donorProjectName = donorProjectName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeKey == null) ? 0 : compositeKey.hashCode());
		result = prime * result + ((getDonorProjectName() == null) ? 0 : getDonorProjectName().hashCode());
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
		result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
		result = prime * result + (int) (getProjectId() ^ (getProjectId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donor other = (Donor) obj;
		if (compositeKey == null) {
			if (other.compositeKey != null)
				return false;
		} else if (!compositeKey.equals(other.compositeKey))
			return false;
		if (getDonorProjectName() == null) {
			if (other.getDonorProjectName() != null)
				return false;
		} else if (!getDonorProjectName().equals(other.getDonorProjectName()))
			return false;
		if (getId() != other.getId())
			return false;
		if (getIdNumber() == null) {
			if (other.getIdNumber() != null)
				return false;
		} else if (!getIdNumber().equals(other.getIdNumber()))
			return false;
		if (getPhoneNumber() == null) {
			if (other.getPhoneNumber() != null)
				return false;
		} else if (!getPhoneNumber().equals(other.getPhoneNumber()))
			return false;
		if (getProjectId() != other.getProjectId())
			return false;
		return true;
	}

}
