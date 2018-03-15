package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoTopicException extends Exception {
	  private static final long serialVersionUID = 8632434538067813982L;
	  

	  public NoTopicException(Throwable message) {
		  super(message);
	  }
	  
	  public NoTopicException(String message) {
		  super(message);
	  }

}
