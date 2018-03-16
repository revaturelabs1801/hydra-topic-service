package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSubtopicException extends RuntimeException{
	  

	  public NoSubtopicException(Throwable message) {
		  super(message);
	  }
	  
	  public NoSubtopicException(String message) {
		  super(message);
	  }
	  

}
