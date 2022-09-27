package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Data;

import java.util.List;

@Data
@Node
public class User {

	@Id @Property
	private String userEmailId;
	private String mobileNum;
	private String firstName;
	private String lastName;
	private List<Address> address;


	
	
	
	
	
}
