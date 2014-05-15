package com.fiuba.tecnicas.logging;

public class LineNumberPattern extends Pattern{
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = String.valueOf(Thread.currentThread().getStackTrace()[layerCalledLogSave].getLineNumber()); 
		message += attribute;
		return message;
	}
	
	/**
	 * @see comentario de metodo setAttributes de ThreadPattern, pero en este caso con patron %L
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
