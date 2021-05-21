package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentExceptionHandler {
	 @ExceptionHandler(value = PaymentFailedException.class)
	public ResponseEntity<Object> exception(PaymentFailedException exception) {
	      return new ResponseEntity<>("Payment Failed", HttpStatus.NOT_FOUND);
	   }
}
