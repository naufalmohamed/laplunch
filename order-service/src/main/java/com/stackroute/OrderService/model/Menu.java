package com.stackroute.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Menu {
	int itemId;
	String itemName;
	String itemDescription;
	int qty;
	boolean isVeg;
	long itemCost;
	String image;

}
