package com.recommendationservice.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node
public class OrderMenu {
    @Id @Property
    int itemId;
    String itemName;
    String itemDescription;
    int qty;
    boolean isVeg;
    long itemCost;
    String image;
}
