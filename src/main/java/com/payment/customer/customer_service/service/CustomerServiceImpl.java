package com.payment.customer.customer_service.service;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.payment.customer.customer_service.Repository.CustomerRepository;
import com.payment.customer.customer_service.common.CommonUtils;
import com.payment.customer.customer_service.errorhandling.BadRequestException;
import com.payment.customer.customer_service.errorhandling.DatabaseAccessException;
import com.payment.customer.customer_service.model.dtos.CustomerDetailsDTO;
import com.payment.customer.customer_service.model.entity.CustomerDetails;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;

	@Override
	public void insert(CustomerDetailsDTO details) throws BadRequestException, DatabaseAccessException {

		if (details == null) {
			throw new BadRequestException("Details of the customer can't be empty");
		} else {
			CustomerDetails customerDetails = CommonUtils.mapDetails(details, false, null);
			try {
				repository.save(customerDetails);
			} catch (HibernateException e) {
				throw new DatabaseAccessException(e.getMessage(), e);
			}
		}
	}

	@Override
	public CustomerDetailsDTO update(int customerId, CustomerDetailsDTO details)
			throws BadRequestException, DatabaseAccessException {
		if (customerId == 0) {
			throw new BadRequestException("Customer Id is invalid");
		}

		if (details == null)
			throw new BadRequestException("Details of the customer can't be empty");

		Optional<CustomerDetails> existingCustomer = repository.findByPanAndAahar(details.getPan(),
				details.getAadhar());
		if (existingCustomer.isPresent() && repository.existsById(customerId)) {
			CustomerDetails existingCustomerDetails = existingCustomer.get();
			CustomerDetails customerDetails = CommonUtils.mapDetails(details, true, existingCustomerDetails);
			try {
				repository.save(customerDetails);
			} catch (HibernateException e) {
				throw new DatabaseAccessException(e.getMessage(), e);
			}
		} else {
			throw new BadRequestException("customer Id" + customerId + " not exist");
		}
		return details;
	}

	@Override
	public CustomerDetailsDTO getDetails(int customerId) throws BadRequestException {
		if (customerId == 0) {
			throw new BadRequestException("Customer Id is invalid");
		}

		if (repository.existsById(customerId)) {
			return CommonUtils.mapEntityToDTO(repository.findById(customerId).get());
		} else {
			throw new BadRequestException("customer Id" + customerId + " not exist");
		}
	}

}
