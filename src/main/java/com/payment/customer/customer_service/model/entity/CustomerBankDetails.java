package com.payment.customer.customer_service.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_bank_details")
public class CustomerBankDetails {
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerDetails customerDetails;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_bank_id")
	private int bankId;
	
	@Column(name= "customer_bankname")
	private String bankName;
	
	@Column(name= "customer_bank_address")
	private String bankAddress;
	
	@Column(name= "customer_bank_account_no")
	private String bankAccountNo;
	
	@Column(name= "customer_bank_branch_ifsc_code")
	private String branchIfscCode;
	
	@Column(name= "customer_bank_micr_code")
	private String bankMicrCode;
	
	@Column(name= "customer_bank_branch_name")
	private String branchName;

	@Column(name= "customer_bank_account_type")
	private String bankAccountType;
	
}

