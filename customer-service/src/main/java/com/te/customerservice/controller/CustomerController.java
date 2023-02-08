package com.te.customerservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.customerservice.service.CustomerService;
import com.te.feignclients.dto.CustomerDto;
import com.te.feignclients.response.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/customers")
@RestController
public class CustomerController {
	
	private final CustomerService customerService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "/")
	public SuccessResponse<String> saveCustomer(@RequestBody CustomerDto customerDto){
		
		return SuccessResponse.<String>builder()
				.message("Customer")
				.data(customerService.saveCustomer(customerDto))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/{customerId}")
	public SuccessResponse<CustomerDto> getCustomer(@PathVariable String customerId){
		return SuccessResponse.<CustomerDto>builder()
				.message("Provided Customer Id by the customer")
				.data(customerService.getCustomer(customerId))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/")
	public SuccessResponse<List<CustomerDto>> getCustomers(){
		return SuccessResponse.<List<CustomerDto>>builder()
				.message("Provided all the customers")
				.data(customerService.getCustomers())
				.build();
	}

}
