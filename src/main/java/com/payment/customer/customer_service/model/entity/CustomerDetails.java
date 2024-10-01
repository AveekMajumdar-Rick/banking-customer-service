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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
	
	
}	
