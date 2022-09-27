package com.menuservice.menu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
//@Getter
//@Setter
@Data
@Document(collection="menuitems")
public class MenuModel {


	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";


	@Id
	private int itemId;
	@Field(name="name")
	@Indexed(unique = true)
	private String itemName;
	@Field(name="description")
	private String itemDescription;
	@Field(name="category")
	private String category;
	@Field(name="cost")
	private long itemCost;
	@Field(name="image")
	private String itemImage;
	private SubPlansEnum subPlansEnum;
	
}
