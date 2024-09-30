package com.payment.customer.customer_service.model.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDetailsDTO {


	private String customerName;

	private String phone;

	private String pan;

	private String aadhar;

	private List<CustomerAddressDTO> address;

	private List<CustomerBankDetailsDTO> bankDetails;
}
