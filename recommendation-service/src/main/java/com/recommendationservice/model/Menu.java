package com.recommendationservice.model;

import java.util.List;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
@Data
@Node
public class Menu {
	@Id @Property
	private int itemId;
	private String itemName;
	private String itemDescription;
	private String category;
	private Long itemCost;
	private String itemImage;
	private String subPlansEnum;
}
