package com.niit.timetable.exceptions;





import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Time Table Not Found")
public class TimeTableNotFoundExceptions extends Exception {

	
}
