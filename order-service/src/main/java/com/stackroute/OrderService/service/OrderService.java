package com.stackroute.OrderService.service;

import com.stackroute.OrderService.exceptions.OrderAlreadyExistsException;
import com.stackroute.OrderService.exceptions.OrderNotFoundException;
import com.stackroute.OrderService.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.OrderService.Respository.OrderRepository;
import com.stackroute.OrderService.model.OrderModel;


import java.util.ArrayList;
import java.util.List;

import static com.stackroute.OrderService.model.OrderModel.SEQUENCE_NAME;


@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	private SequenceGeneratorService service;



	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;

	}

	public OrderModel addOrder(OrderModel orderModel) throws OrderAlreadyExistsException {
		if(orderRepository.existsById(orderModel.getOrderId())) {
			throw new OrderAlreadyExistsException();
		}
		orderModel.setOrderId(service.getSequenceNumber(SEQUENCE_NAME));
//		int sum = 0;
//		for (Menu item : orderModel.getItemsList()) {
//			sum = (int) (sum + item.getItemCost()* item.getQty());
//		}
//		orderModel.setTotalPrice(sum);
		orderRepository.insert(orderModel);
		return orderModel;
	}

    public List<OrderModel> getOrders() throws OrderNotFoundException {
		if(orderRepository.findAll().isEmpty()){
			throw new OrderNotFoundException();
		}
		return orderRepository.findAll();
    }

	public OrderModel getOrderById(int orderId) throws OrderNotFoundException {

			if (orderRepository.findById(orderId).isPresent()) {
				return orderRepository.findById(orderId).get();
			}
			else{
				throw new OrderNotFoundException();
			}
	}

	public void deleteByOrderId(int orderId) throws OrderNotFoundException {
		if (orderRepository.findById(orderId).isPresent()) {
			orderRepository.deleteById(orderId);
		}
		else{
			throw new OrderNotFoundException();
		}
	}


	public void updateOrder(OrderModel orderModel) throws OrderNotFoundException {
		if(orderRepository.findById(orderModel.getOrderId()).isPresent()){
			throw new OrderNotFoundException();
		}
		orderRepository.save(orderModel);
	}

	public List<OrderModel> getOrdersByUserEmail(String userEmailId) throws OrderNotFoundException{
		List<OrderModel> allOrders=this.orderRepository.findAll();
		List<OrderModel> userOrders = new ArrayList<OrderModel>();
		for(OrderModel or:allOrders){
			if(or.getUserEmailId().equals(userEmailId)){
				userOrders.add(or);
			}
		}
		if(userOrders.isEmpty()){
			throw new OrderNotFoundException();
		}
		return userOrders;
	}
}
