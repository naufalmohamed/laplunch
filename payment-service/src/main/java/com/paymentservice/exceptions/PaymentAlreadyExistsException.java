package com.paymentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason = "Payment already exists")
public class PaymentAlreadyExistsException extends Exception{
    public PaymentAlreadyExistsException() {
        super("Payment already exists");
    }
}
