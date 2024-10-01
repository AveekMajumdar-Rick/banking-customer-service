package com.payment.customer.customer_service.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DatabaseAccessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134949404326763527L;

	public DatabaseAccessException(String exception, Throwable e) {
		super(exception, e);
	}
}
