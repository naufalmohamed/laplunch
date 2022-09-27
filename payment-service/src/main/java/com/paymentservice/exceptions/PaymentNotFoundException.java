package com.paymentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Payment not found")
public class PaymentNotFoundException extends Exception {
    public PaymentNotFoundException() {
        super("Payment not found");
    }
}
