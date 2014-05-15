package com.fiuba.tecnicas.logging;

public class SeparatorPattern extends Pattern{

	@Override
	public String getMessage() {
		String message = this.log.getSeparator();
		message += this.attribute;
		return message;
	}
	
	
	/**
	 * @see comentario de setAttributes de ThreadPattern, pero en este caso con patron %n
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
