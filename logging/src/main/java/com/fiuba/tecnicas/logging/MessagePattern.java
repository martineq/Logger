package com.fiuba.tecnicas.logging;

public class MessagePattern extends Pattern{

	@Override
	public String getMessage() {
		String message = this.log.getMessage();
		message += this.attribute;
		return message;
	}
	
	/**
	 * @see comentario de metodo setAttributes de ThreadPattern, pero en este caso con patron %m
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
