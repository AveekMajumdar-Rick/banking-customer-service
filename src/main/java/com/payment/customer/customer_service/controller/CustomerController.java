package com.payment.customer.customer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.customer.customer_service.errorhandling.BadRequestException;
import com.payment.customer.customer_service.errorhandling.DatabaseAccessException;
import com.payment.customer.customer_service.model.dtos.CustomerDetailsDTO;
import com.payment.customer.customer_service.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	public String hello() {
		return "hellooo from customer service";
	}

	@PostMapping("/customer/details")
	public ResponseEntity<?> insertCustomerDetails(@RequestBody CustomerDetailsDTO details)
			throws BadRequestException, DatabaseAccessException {
		customerService.insert(details);
		return ResponseEntity.accepted().build();
	}

	@PutMapping("/customer/{customer_id}/details")
	public ResponseEntity<CustomerDetailsDTO> updateCustomerDetails(@PathVariable("customer_id") int customerId,
			@RequestBody CustomerDetailsDTO details) throws BadRequestException, DatabaseAccessException {
		return new ResponseEntity<CustomerDetailsDTO>(customerService.update(customerId, details), HttpStatus.OK);
	}

	@GetMapping("/customer/{customer_id}/details")
	public ResponseEntity<CustomerDetailsDTO> getCustomerDetails(@PathVariable("customer_id") int customerId)
			throws BadRequestException {
		return new ResponseEntity<CustomerDetailsDTO>(customerService.getDetails(customerId), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/customer/{customer_id}/details/delete")
	public ResponseEntity<?> deleteCustomerDetails(@PathVariable("customer_id") int customerId) throws BadRequestException {
		customerService.delete(customerId);
		return ResponseEntity.noContent().build();
	}
	
}
