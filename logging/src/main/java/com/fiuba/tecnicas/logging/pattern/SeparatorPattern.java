package com.fiuba.tecnicas.logging.pattern;


public class SeparatorPattern extends Pattern{

	@Override
	public String getMessage() {
		String message = this.log.getSeparator();
		message += this.attribute;
		return message;
	}
	

}
