package com.te.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.orderservice.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
