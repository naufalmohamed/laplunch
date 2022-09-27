package com.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Order {

    public static final String SEQUENCE_NAME = "user_sequence";


    private int orderId; //unique Id for each order

    private String userEmailId;

    private Address address;

    private String status="Payment pending"; //status: Payment pending, placed

    private int totalPrice = 0; //total price for items, generates logically
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time; //time at which user ordered
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderScheduleTime; //time at which order will be delivered
    private List<Menu> itemsList; //list of items
}
