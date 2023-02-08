package com.te.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.customerservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
