package com.payment.customer.customer_service.common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.payment.customer.customer_service.model.dtos.CustomerAddressDTO;
import com.payment.customer.customer_service.model.dtos.CustomerBankDetailsDTO;
import com.payment.customer.customer_service.model.dtos.CustomerDetailsDTO;
import com.payment.customer.customer_service.model.entity.CustomerAddress;
import com.payment.customer.customer_service.model.entity.CustomerBankDetails;
import com.payment.customer.customer_service.model.entity.CustomerDetails;

public class CommonUtils {

	public static CustomerDetails mapDetails(CustomerDetailsDTO customerDetailsDTO, boolean customerExists,
			CustomerDetails existingCustomer) {
		CustomerDetails customerDetails;

		// If the customer exists, reuse the existing entity, otherwise create a new one
		if (customerExists) {
			customerDetails = existingCustomer;
		} else {
			customerDetails = new CustomerDetails(); // New customer creation
			customerDetails.setPan(customerDetailsDTO.getPan()); // Set unique fields for new customer
			customerDetails.setAahar(customerDetailsDTO.getAadhar());
		}

		customerDetails.setCustomerName(customerDetailsDTO.getCustomerName());
		customerDetails.setPhone(new BigInteger(customerDetailsDTO.getPhone()));

		// --- Handle Addresses ---
		List<CustomerAddress> existingAddresses = customerDetails.getAddress(); // Fetch existing addresses
		List<CustomerAddress> updatedAddresses = new ArrayList<>();

		for (CustomerAddressDTO addressDTO : customerDetailsDTO.getAddress()) {

			if (customerExists) {
				existingAddresses.forEach(existing -> {
					existing.setAddress1(addressDTO.getAddress1());
					existing.setAddress2(addressDTO.getAddress2());
					existing.setCustomerCity(addressDTO.getCustomerCity());
					existing.setCustomerState(addressDTO.getCustomerState());
					existing.setCustomerAddressType(addressDTO.getCustomerAddressType());
					existing.setCustomerPincode(addressDTO.getCustomerPincode());
					updatedAddresses.add(existing); // Add to updated list
				});
				// Update the existing address
			} else {
				// Create a new address if it doesn't exist
				CustomerAddress newAddress = new CustomerAddress();
				newAddress.setAddress1(addressDTO.getAddress1());
				newAddress.setAddress2(addressDTO.getAddress2());
				newAddress.setCustomerCity(addressDTO.getCustomerCity());
				newAddress.setCustomerState(addressDTO.getCustomerState());
				newAddress.setCustomerAddressType(addressDTO.getCustomerAddressType());
				newAddress.setCustomerPincode(addressDTO.getCustomerPincode());
				newAddress.setDetails(customerDetails); // Link to customer
				updatedAddresses.add(newAddress);
			}
		}
		customerDetails.setAddress(updatedAddresses); // Set the updated addresses list

		// --- Handle Bank Details ---
		List<CustomerBankDetails> existingBankDetails = customerDetails.getBankDetails(); // Fetch existing bank details
		List<CustomerBankDetails> updatedBankDetailsList = new ArrayList<>();

		for (CustomerBankDetailsDTO bankDetailsDTO : customerDetailsDTO.getBankDetails()) {
			// Check if the bank details already exist (again, assuming you have an ID or
			// unique field)
			CustomerBankDetails existingBankDetailsEntry = existingBankDetails.stream()
					.filter(bank -> bank.getBankAccountNo().equals(bankDetailsDTO.getBankAccountNo())) // comparing with
																										// bank account
																										// no
					.findFirst().orElse(null);

			if (existingBankDetailsEntry != null) {
				// Update the existing bank details
				existingBankDetailsEntry.setBankAddress(bankDetailsDTO.getBankAddress());
				existingBankDetailsEntry.setBranchIfscCode(bankDetailsDTO.getBranchIfscCode());
				existingBankDetailsEntry.setBankMicrCode(bankDetailsDTO.getBankMicrCode());
				existingBankDetailsEntry.setBranchName(bankDetailsDTO.getBranchName());
				existingBankDetailsEntry.setBankAccountType(bankDetailsDTO.getBankAccountType());
				updatedBankDetailsList.add(existingBankDetailsEntry); // Add to updated list
			} else {
				// Create new bank details if they don't exist
				CustomerBankDetails newBankDetails = new CustomerBankDetails();
				newBankDetails.setBankName(bankDetailsDTO.getBankName());
				newBankDetails.setBankAddress(bankDetailsDTO.getBankAddress());
				newBankDetails.setBankAccountNo(bankDetailsDTO.getBankAccountNo());
				newBankDetails.setBranchIfscCode(bankDetailsDTO.getBranchIfscCode());
				newBankDetails.setBankMicrCode(bankDetailsDTO.getBankMicrCode());
				newBankDetails.setBranchName(bankDetailsDTO.getBranchName());
				newBankDetails.setBankAccountType(bankDetailsDTO.getBankAccountType());
				newBankDetails.setCustomerDetails(customerDetails); // Link to customer
				updatedBankDetailsList.add(newBankDetails);
			}
		}
		customerDetails.setBankDetails(updatedBankDetailsList); // Set the updated bank details list

		return customerDetails;
	}

	public static CustomerDetailsDTO mapEntityToDTO(CustomerDetails customerDetails) {
		// Initialize the DTO
		CustomerDetailsDTO customerDetailsDTO = new CustomerDetailsDTO();

		// Map basic customer details
		customerDetailsDTO.setCustomerName(customerDetails.getCustomerName());
		customerDetailsDTO.setPhone(customerDetails.getPhone().toString());
		customerDetailsDTO.setPan(customerDetails.getPan());
		customerDetailsDTO.setAadhar(customerDetails.getAahar());

		// Map the list of addresses from entity to DTO
		List<CustomerAddressDTO> addressDTOList = new ArrayList<>();
		for (CustomerAddress customerAddress : customerDetails.getAddress()) {
			CustomerAddressDTO addressDTO = new CustomerAddressDTO();
			addressDTO.setAddress1(customerAddress.getAddress1());
			addressDTO.setAddress2(customerAddress.getAddress2());
			addressDTO.setCustomerCity(customerAddress.getCustomerCity());
			addressDTO.setCustomerState(customerAddress.getCustomerState());
			addressDTO.setCustomerPincode(customerAddress.getCustomerPincode());
			addressDTO.setCustomerAddressType(customerAddress.getCustomerAddressType());
			addressDTOList.add(addressDTO);
		}
		customerDetailsDTO.setAddress(addressDTOList);

		// Map the list of bank details from entity to DTO
		List<CustomerBankDetailsDTO> bankDetailsDTOList = new ArrayList<>();
		for (CustomerBankDetails customerBankDetails : customerDetails.getBankDetails()) {
			CustomerBankDetailsDTO bankDetailsDTO = new CustomerBankDetailsDTO();
			bankDetailsDTO.setBankName(customerBankDetails.getBankName());
			bankDetailsDTO.setBankAddress(customerBankDetails.getBankAddress());
			bankDetailsDTO.setBankAccountNo(customerBankDetails.getBankAccountNo());
			bankDetailsDTO.setBranchIfscCode(customerBankDetails.getBranchIfscCode());
			bankDetailsDTO.setBankMicrCode(customerBankDetails.getBankMicrCode());
			bankDetailsDTO.setBranchName(customerBankDetails.getBranchName());
			bankDetailsDTO.setBankAccountType(customerBankDetails.getBankAccountType());
			bankDetailsDTOList.add(bankDetailsDTO);
		}
		customerDetailsDTO.setBankDetails(bankDetailsDTOList);

		return customerDetailsDTO;
	}
}
