package com.payment.customer.customer_service.model.entity;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name= "customer_name")
	private String customerName;
	
	@Column(name = "customer_phone")
	private BigInteger phone;
	
	@Column(name = "customer_pan")
	private String pan;
	
	@Column(name= "customer_aadhar")
	private String aahar;
	
	@OneToMany(mappedBy = "details", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerAddress> address;
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerBankDetails> bankDetails;

	
	
	public CustomerDetails() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAahar() {
		return aahar;
	}

	public void setAahar(String aahar) {
		this.aahar = aahar;
	}

	public List<CustomerAddress> getAddress() {
		return address;
	}

	public void setAddress(List<CustomerAddress> address) {
		this.address = address;
	}

	public List<CustomerBankDetails> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(List<CustomerBankDetails> bankDetails) {
		this.bankDetails = bankDetails;
	}
	
	
	
}	
