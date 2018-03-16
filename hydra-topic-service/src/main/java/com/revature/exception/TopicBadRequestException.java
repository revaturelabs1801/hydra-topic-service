package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TopicBadRequestException extends RuntimeException{
	
	  public TopicBadRequestException(Throwable message) {
		  super(message);
	  }
	  
	  public TopicBadRequestException(String message) {
		  super(message);
	  }
	
}
