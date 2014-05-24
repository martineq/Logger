package com.fiuba.tecnicas.logging.Pattern;


public class ThreadPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = Thread.currentThread().getName();
		message += this.attribute;
		return message;
	}
	
	
}