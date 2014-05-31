package com.fiuba.tecnicas.logging.logException;

import com.fiuba.tecnicas.logging.Log;
import com.fiuba.tecnicas.logging.MessageParser;

public class LogException extends Log {

	private Throwable exception;

	public LogException(String message, String level) {
		super(message, level);
	}
	
	public LogException(String message, String level,Throwable exception) {
		super(message, level);
		
		this.exception = exception;
	}
	
	public String getMessage() {
		return this.message+" "+exception.getMessage();
	}

}
