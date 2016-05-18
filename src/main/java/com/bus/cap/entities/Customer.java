package com.bus.cap.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CREATE TABLE capture.Customer( User_Id CHAR(20) NOT NULL, Business_Id
 * MEDIUMINT, Name CHAR(30) NOT NULL, Address CHAR(100) NOT NULL, City CHAR(30)
 * NULL, Email CHAR(40) NOT NULL, Mobile_Number CHAR(20) NOT NULL,
 * Telephone_Number CHAR(20) NOT NULL, Parent tinyint, Customer_Type CHAR(30)
 * NOT NULL, Parent_User_Id CHAR(20) NULL, PRIMARY KEY (User_Id), FOREIGN
 * KEY(Business_Id) REFERENCES Business(Business_Id) );
 * 
 * 
 * **/
@Entity
@Table(name = "Customer")
public class Customer {
	private Business business;
	private String userId;
	private String name;
	private String address;
	private String city;
	private String email;
	private String mobileNumber;
	private String telephoneNumber;
	private boolean parent;
	private String customerType;
	private String parentUserId;
	private List<Album> album;

	@Id
	@Column(name = "User_Id", unique = true, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Mobile_Number", nullable = false)
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "Telephone_Number", nullable = false)
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Column(name = "Parent")
	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

	@Column(name = "Customer_Type", nullable = false)
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Column(name = "Parent_User_Id")
	public String getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(String parentUserId) {
		this.parentUserId = parentUserId;
	}

	@ManyToOne
	@JoinColumn(name = "Business_Id")
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}
}
