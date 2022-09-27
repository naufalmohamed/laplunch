package com.notificationservice.model;

import lombok.Data;

@Data
public class Menu {
    int itemId;
    String itemName;
    String itemDescription;
    int qty;
    boolean isVeg;
    long itemCost;
    String image;
}
