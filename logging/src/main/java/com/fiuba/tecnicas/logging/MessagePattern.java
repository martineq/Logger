package com.fiuba.tecnicas.logging;

public class MessagePattern extends Pattern{

	@Override
	public String getMessage() {
		String message = this.log.getMessage();
		message += this.attribute;
		return message;
	}
	
}
