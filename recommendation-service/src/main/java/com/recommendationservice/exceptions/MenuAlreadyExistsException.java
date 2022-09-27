package com.recommendationservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Already Exists")

public class MenuAlreadyExistsException extends Exception {

}
