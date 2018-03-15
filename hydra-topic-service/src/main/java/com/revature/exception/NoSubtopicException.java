package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSubtopicException extends RuntimeException{
	  private static final long serialVersionUID = 8632434538067813982L;
	  

	  public NoSubtopicException(Throwable message) {
		  super(message);
	  }
	  
	  public NoSubtopicException(String message) {
		  super(message);
	  }
	  

}
