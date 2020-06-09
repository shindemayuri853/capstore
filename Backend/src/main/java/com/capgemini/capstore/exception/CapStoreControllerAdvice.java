package com.capgemini.capstore.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.capstore.response.CapstoreResponse;

@RestControllerAdvice
public class CapStoreControllerAdvice {
	@ExceptionHandler(FetchNullListException.class)
	public CapstoreResponse capStoreErrorResponse(FetchNullListException fetchNullListException) {
		CapstoreResponse capStoreResponse = new CapstoreResponse();
		capStoreResponse.setStatusCode(401);
		capStoreResponse.setMessage("Failed");
		capStoreResponse.setDescription("Null List");
		return capStoreResponse;
	}
	
	@ExceptionHandler(UnableToAddException.class)
	public CapstoreResponse capStoreErrorResponse(UnableToAddException unableToAddException) {
		CapstoreResponse capStoreResponse = new CapstoreResponse();
		capStoreResponse.setStatusCode(401);
		capStoreResponse.setMessage("Failed");
		capStoreResponse.setDescription("Unable To Add Data");
		return capStoreResponse;
	}
	
	@ExceptionHandler(UnableToDeleteException.class)
	public CapstoreResponse capStoreErrorResponse(UnableToDeleteException unableToDeleteException) {
		CapstoreResponse capStoreResponse = new CapstoreResponse();
		capStoreResponse.setStatusCode(401);
		capStoreResponse.setMessage("Failed");
		capStoreResponse.setDescription("Unable To Delete Data");
		return capStoreResponse;
	}
	
	@ExceptionHandler(UnableToUpdateException.class)
	public CapstoreResponse capStoreErrorResponse(UnableToUpdateException unableToUpdateException) {
		CapstoreResponse capStoreResponse = new CapstoreResponse();
		capStoreResponse.setStatusCode(401);
		capStoreResponse.setMessage("Failed");
		capStoreResponse.setDescription("Unable To Update Data");
		return capStoreResponse;
	}
}
