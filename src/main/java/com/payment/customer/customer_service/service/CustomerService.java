package com.payment.customer.customer_service.service;

import com.payment.customer.customer_service.errorhandling.BadRequestException;
import com.payment.customer.customer_service.errorhandling.DatabaseAccessException;
import com.payment.customer.customer_service.model.dtos.CustomerDetailsDTO;

public interface CustomerService {

	void insert(CustomerDetailsDTO details) throws BadRequestException, DatabaseAccessException;

	CustomerDetailsDTO update(int customerId, CustomerDetailsDTO details) throws BadRequestException, DatabaseAccessException;

	CustomerDetailsDTO getDetails(int customerId) throws BadRequestException;

	void delete(int customerId) throws BadRequestException;
	
}
