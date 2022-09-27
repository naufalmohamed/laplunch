package com.recommendationservice.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Node
public class RelationshipModel {
	@Id
	private Long orderId;
	private String userEmailId;
	private Address address;
	private int totalPrice;
	@Setter(AccessLevel.NONE)
	private LocalDateTime time; //time at which user ordered
	@Setter(AccessLevel.NONE)
	private LocalDateTime orderScheduleTime; //time at which order will be delivered
	private List<OrderMenu> itemsList; //list of items

}
