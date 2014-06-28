package com.fiuba.tecnicas.logging.pattern;


public class MessagePattern extends Pattern{

	@Override
	public String getMessage() {
		String message = this.log.getMessage();
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof MessagePattern;
	}
	
}
