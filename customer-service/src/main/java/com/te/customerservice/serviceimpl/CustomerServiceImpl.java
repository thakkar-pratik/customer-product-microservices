package com.te.customerservice.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.customerservice.entity.Customer;
import com.te.customerservice.exception.CustomerNotFoundException;
import com.te.customerservice.repository.CustomerRepository;
import com.te.customerservice.service.CustomerService;
import com.te.feignclients.dto.CustomerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public String saveCustomer(CustomerDto customerDto) {
		return customerRepository.save(Customer.builder().customerId(UUID.randomUUID().toString())
				.customerEmail(customerDto.getCustomerEmail()).customerName(customerDto.getCustomerName()).build())
				.getCustomerId();
	}

	@Override
	public CustomerDto getCustomer(String customerId) {
		return customerRepository.findById(customerId).map(customer -> {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(customer, customerDto);
			return customerDto;
		}).orElseThrow(() -> new CustomerNotFoundException("CUSTOMER_WITH_GIVEN_ID_COULD_NOT_BE_FOUND"));
	}

	@Override
	public List<CustomerDto> getCustomers() {
		return customerRepository.findAll().stream().map(customer -> {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(customer, customerDto);
			return customerDto;
		}).collect(Collectors.toList());
	}

}
