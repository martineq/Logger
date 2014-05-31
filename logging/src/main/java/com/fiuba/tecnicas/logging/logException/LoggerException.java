package com.fiuba.tecnicas.logging.logException;

import com.fiuba.tecnicas.logging.Logger;
import com.fiuba.tecnicas.logging.LoggerSettings;

public class LoggerException extends Logger{

	private Throwable exception;

	public LoggerException(String loggerName){
		super(loggerName);
	}
	
	
	public void logMessage(String message, Throwable exception2, String nivel){
		if(canLog(nivel)){
			LogException log = new LogException(message,nivel,exception2);
			log.setConfig(configuration);
			log.save();
		}
			
	}
	
}
