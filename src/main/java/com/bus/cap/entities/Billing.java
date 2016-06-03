package com.bus.cap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * CREATE TABLE capture.Billing( Billing_Id MEDIUMINT AUTO_INCREMENT,
 * Business_Id MEDIUMINT, Amount DOUBLE(16,2), Paid_By CHAR(50), Paid_Date
 * TIMESTAMP, PRIMARY KEY(Billing_Id), FOREIGN KEY(Business_Id) REFERENCES
 * Business(Business_Id) );
 * */
@Entity
@Table(name = "Billing")
public class Billing {
	private Long billingId;
	private Business business;
	private Double amount;
	private String paidBy;
	private Date paidDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Billing_Id")
	public Long getBillingId() {
		return billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	@Column(name = "Amount")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "Paid_By", nullable = false)
	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	@Column(name = "Paid_Date", nullable = false)
	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	@OneToOne
	@JoinColumn(name="Business_Id")
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
	
	@Override
	public String toString(){
		StringBuffer print = new StringBuffer("Billing[" + billingId + " " + amount + " " + paidBy + " " + paidDate + "]" );
		if(null != business){
			print.append(business);
		}
		return print.toString();
	}

}
