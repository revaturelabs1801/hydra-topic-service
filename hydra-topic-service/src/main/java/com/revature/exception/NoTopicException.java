package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoTopicException extends RuntimeException {
	  

	  public NoTopicException(Throwable message) {
		  super(message);
	  }
	  
	  public NoTopicException(String message) {
		  super(message);
	  }

}
