package com.payment.customer.customer_service.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_address")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_address_id")
	private int addressId;

	@Column(name = "customer_address_line_1")
	private String address1;

	@Column(name = "customer_address_line_2")
	private String address2;

	@Column(name = "customer_city")
	private String customerCity;

	@Column(name = "customer_state")
	private String customerState;
	
	@Column(name = "customer_address_type")
	private String customerAddressType;

	@Column(name = "customer_pincode")
	private int customerPincode;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerDetails details;
	
}
