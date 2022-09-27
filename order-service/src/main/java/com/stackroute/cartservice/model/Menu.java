package com.stackroute.cartservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

public class Menu {
	int itemId;
	String itemName;
	String itemDescription;
	String category;
	long itemCost;
	String itemImage;
	int Quantity;

}
