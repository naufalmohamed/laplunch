package com.stackroute.OrderService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Order not found")
public class OrderNotFoundException extends Exception {
    public OrderNotFoundException() {
        super("Order not found");
    }
}
