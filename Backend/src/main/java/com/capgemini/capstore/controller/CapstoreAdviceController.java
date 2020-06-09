package com.capgemini.capstore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.response.CapstoreResponse;

@RestControllerAdvice
public class CapstoreAdviceController {
	@ExceptionHandler(CapstoreException.class)
	public CapstoreResponse capstoreErrorResponse(CapstoreException exception) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		capstoreResponse.setStatusCode(400);
		capstoreResponse.setMessage("Failure");
		capstoreResponse.setDescription(exception.getMessage());
		return capstoreResponse;
	}
}