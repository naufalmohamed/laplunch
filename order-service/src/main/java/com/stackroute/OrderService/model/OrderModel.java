package com.stackroute.OrderService.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class OrderModel {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private int orderId; //unique Id for each order

	private String userEmailId;

	private Address address;

	private int totalPrice; //total price for items, generates logically

	@Setter(AccessLevel.NONE)
	private LocalDateTime time; //time at which user ordered

	@Setter(AccessLevel.NONE)
	private LocalDateTime orderScheduleTime; //time at which order will be delivered


	private List<Menu> itemsList; //list of items

	public OrderModel() {
		super();
		this.time = LocalDateTime.now();
		this.orderScheduleTime = this.time.plusMinutes(30);

	}

	public OrderModel(int orderId, String userEmailId, List<Menu> itemsList, Address address, int totalPrice) {
		this.orderId = orderId;
		this.userEmailId = userEmailId;
		this.itemsList = itemsList;
		this.address=address;
		this.totalPrice=totalPrice;
	}


}