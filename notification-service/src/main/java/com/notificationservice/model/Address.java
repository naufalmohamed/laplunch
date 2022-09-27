package com.notificationservice.model;

import lombok.Data;

@Data
public class Address {
    private String addressType;
    private String houseNum;
    private String street;
    private String city;
    private String state;
    private Long pincode;
}
