package com.ffs.charity.common.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception exception , WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), exception.getMessage(), request.getDescription(false)) ;
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
