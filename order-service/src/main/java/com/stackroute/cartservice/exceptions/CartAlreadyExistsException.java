package com.stackroute.cartservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Cart already exists")
public class CartAlreadyExistsException extends Exception {

}
