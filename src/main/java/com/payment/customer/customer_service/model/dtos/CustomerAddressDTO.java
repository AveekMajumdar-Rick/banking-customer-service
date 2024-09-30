package com.payment.customer.customer_service.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerAddressDTO {
	
	private String address1;
    private String address2;
    private String customerCity;
    private String customerState;
    private String customerAddressType;
    private int customerPincode;
	
}
