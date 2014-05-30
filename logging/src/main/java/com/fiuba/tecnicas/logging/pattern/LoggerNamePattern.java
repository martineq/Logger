package com.fiuba.tecnicas.logging.pattern;

public class LoggerNamePattern extends Pattern {

	@Override
	public String getMessage() {
		String message = "";
		message += log.getLoggerName();
		message += this.attribute;
		return message;
	}

}
