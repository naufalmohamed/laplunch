package com.recommendationservice.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class Address {
	@Id @GeneratedValue
	private Long id;
	private String addressType;
	private String houseNum;
	private String street;
	private String city;
	private String state;
	private Long pincode;

}
