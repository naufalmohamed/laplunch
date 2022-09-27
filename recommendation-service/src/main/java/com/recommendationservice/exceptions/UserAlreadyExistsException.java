package com.recommendationservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Already Exists")
public class UserAlreadyExistsException extends Exception {

}

