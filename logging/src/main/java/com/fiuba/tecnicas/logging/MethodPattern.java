package com.fiuba.tecnicas.logging;

public class MethodPattern extends Pattern {
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = Thread.currentThread().getStackTrace()[layerCalledLogSave].getMethodName(); 
		message += attribute;
		return message;
	}
	
	/**
	 * @see comentario de setAttributes de ThreadPattern, pero en este caso con patron %M
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
