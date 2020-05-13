package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler
{
	//Add Exception Handling Code Here
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e)
	{
		//Create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		//Return ResponseEntity

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

	}

	//Add another exception handler.... to catch any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e)
	{
		//Create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		//Return ResponseEntity

		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

	}

}
