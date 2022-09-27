package com.menuservice.menu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Thows exception if menu items already exists in database.
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Already Exists")
public class MenuAlreadyExistsException extends Exception{

}
