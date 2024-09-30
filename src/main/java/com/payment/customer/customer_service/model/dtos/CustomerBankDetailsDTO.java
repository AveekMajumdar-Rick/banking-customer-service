package com.payment.customer.customer_service.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerBankDetailsDTO {

	private String bankName;
	private String bankAddress;
	private String bankAccountNo;
	private String branchIfscCode;
	private String bankMicrCode;
	private String branchName;
	private String bankAccountType;

}
