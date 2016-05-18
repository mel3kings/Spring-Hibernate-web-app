package com.bus.cap.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CREATE TABLE capture.Business_Admin(
	User_Id CHAR(30) NOT NULL,
	Business_Id MEDIUMINT,
	User_Name CHAR(50) NOT NULL,
	Password CHAR(50) NOT NULL,
	Email CHAR(50) NOT NULL,
	Role CHAR(20) NOT NULL,
	Mobile_Number CHAR(20) NULL,
	Cellphone_Number CHAR(20) NULL,
	PRIMARY KEY (User_Id),
	FOREIGN KEY (Business_Id) REFERENCES Business(Business_Id)
);

 * **/	
@Entity
@Table(name="Business_Admin")
public class Admin {
	private Business business;
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String role;
	private String mobileNumber;
	private String telephoneNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="Business_Id")
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@Id
	@Column(name="User_Id", unique = true, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name= "User_Name", nullable =false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column (name= "Password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name ="Email" ,nullable =false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="Role", nullable=false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="Cellphone_Number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Column(name="Mobile_Number")
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}
