package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{
	  

	  public NoContentException(Throwable message) {
		  super(message);
	  }
	  
	  public NoContentException(String message) {
		  super(message);
	  }
	  

}
