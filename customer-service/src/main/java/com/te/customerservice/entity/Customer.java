package com.te.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {
	
	@Id
//	@Column(name = "id")
	private String customerId;
	
//	@Column(name = "name")
	private String customerName;
	
//	@Column(name = "email")
	private String customerEmail;

}
