package com.payment.customer.customer_service.errorhandling;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134949404326763527L;

	public BadRequestException(String exception) {
		super(exception);
	}
}
