package com.bus.cap.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * CREATE TABLE capture.Business(
	Business_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
	Business_Name CHAR(30) NOT NULL,
	Business_Address CHAR(50) NOT NULL,
	Business_City CHAR(20) NOT NULL,
	Description CHAR(50) NULL,
    PRIMARY KEY (Business_Id)
);**/
@Entity
@Table(name = "Business")
public class Business {
	private Long businessId;
	private String businessName;
	private String businessAddress;
	private String businessCity;
	private String description;
	private List<Admin> admin;
	private List<Customer> customer;
	private Billing billing;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Business_Id", unique = true, nullable = false)
	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	@Column(name = "Business_Name", nullable = false)
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "Business_Address", nullable = false)
	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	@Column(name = "Business_City", nullable = false)
	public String getBusinessCity() {
		return businessCity;
	}

	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}

	@Column(name = "Description", nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "business", cascade=CascadeType.ALL)
	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="business", cascade= CascadeType.ALL)
	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@OneToOne(fetch= FetchType.LAZY, mappedBy="business")
	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

}
