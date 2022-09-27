package com.stackroute.OrderService.controller;


import com.stackroute.OrderService.exceptions.OrderAlreadyExistsException;
import com.stackroute.OrderService.exceptions.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.OrderService.model.OrderModel;
import com.stackroute.OrderService.service.OrderService;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	
	private final OrderService service;
	
	public OrderController(OrderService service) {
		super();
		this.service = service;
	}


	@PostMapping("/addOrder")
	public ResponseEntity<Object> postOrder(@RequestBody OrderModel order){
		try {
//
			log.info("Order added");
			return new ResponseEntity<>(service.addOrder(order), HttpStatus.CREATED);
		} catch (OrderAlreadyExistsException e) {
			log.error("Order already exists");
			return new ResponseEntity<>("Order already exists", HttpStatus.CONFLICT);
		} catch (Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getOrders")
	public ResponseEntity<Object> getOrders(){

		try {
			log.info("getting orders");
			return ResponseEntity.ok(service.getOrders());
		} catch (OrderNotFoundException e) {
			log.error("orders not found");
			return new ResponseEntity<Object>("orders not found",HttpStatus.CONFLICT);
		} catch (Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Object> getOrderById(@PathVariable("orderId") int orderId){

		try {
			log.info("getting order by Id");
			return new ResponseEntity<Object>(service.getOrderById(orderId),HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			log.error("Order not found");
			return new ResponseEntity<>("Order not found",HttpStatus.CONFLICT);
		} catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<Object> updateOrder(@RequestBody OrderModel orderModel){
		try {
			service.updateOrder(orderModel);
			log.info("Order updated!!");
			return new ResponseEntity<Object>("Order updated!!",HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			log.error("Order not exists");
			return new ResponseEntity<>("Order not exists",HttpStatus.CONFLICT);
		} catch (Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<Object> deleteOrderByOrderId(@PathVariable int orderId){
		try {
			service.deleteByOrderId(orderId);
			log.info("Order deleted");
			return new ResponseEntity<>("Order deleted",HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			log.error("Order not found");
			return new ResponseEntity<>("Order not found",HttpStatus.CONFLICT);
		} catch (Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/getOrders/{userEmailId}")
	public ResponseEntity<Object> getOrderByUserEmailId(@PathVariable("userEmailId") String emailId){

		try {
			log.info("getting order by userEmailId");
			return new ResponseEntity<Object>(service.getOrdersByUserEmail(emailId),HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			log.error("Orders not found for this user");
			return new ResponseEntity<>("Orders not found for this user",HttpStatus.CONFLICT);
		} catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
