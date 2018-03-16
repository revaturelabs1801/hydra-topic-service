package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SubtopicInternalException extends RuntimeException {
	
	  public SubtopicInternalException(Throwable message) {
		  super(message);
	  }
	  
	  public SubtopicInternalException(String message) {
		  super(message);
	  }
	
	
}
