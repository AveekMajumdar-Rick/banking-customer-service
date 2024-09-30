package com.payment.customer.customer_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.customer.customer_service.model.entity.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{

	Optional<CustomerDetails> findByPanAndAahar(String pan, String aadhar);
	
	

}
