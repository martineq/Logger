package com.fiuba.tecnicas.logging.pattern;

public class LoggerNamePattern extends Pattern {

	@Override
	public String getMessage() {
		String message = "";
		message += log.getLoggerName();
		message += this.attribute;
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof LoggerNamePattern;
	}

}
