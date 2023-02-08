package com.te.customerservice.service;

import java.util.List;

import com.te.feignclients.dto.CustomerDto;

public interface CustomerService {

	String saveCustomer(CustomerDto customerDto);

	CustomerDto getCustomer(String customerId);

	List<CustomerDto> getCustomers();

}
