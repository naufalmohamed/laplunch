package com.stackroute.OrderService.Respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.OrderService.model.OrderModel;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, Integer> {

}
