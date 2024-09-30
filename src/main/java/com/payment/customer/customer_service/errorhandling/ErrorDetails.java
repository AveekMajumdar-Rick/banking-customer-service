package com.payment.customer.customer_service.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

	
	private int errorCode;
	private String errorMessage;

	
}
