package com.niit.timetable.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "TimeTable Already Exists")
public class TimeTableAlreadyExistsExceptions extends Exception{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 3264201694401320929L;

}
