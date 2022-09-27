package com.stackroute.cartservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Cart Not Found")
public class CartNotFoundException extends Exception {

}

