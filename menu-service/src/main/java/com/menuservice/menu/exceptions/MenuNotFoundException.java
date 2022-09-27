package com.menuservice.menu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Thows exception if menu items doesnot exists in database.
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Not Found")
public class MenuNotFoundException extends Exception {

}
