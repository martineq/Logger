package com.fiuba.tecnicas.logging.Pattern;


public class MethodPattern extends Pattern {
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = Thread.currentThread().getStackTrace()[layerCalledLogSave].getMethodName(); 
		message += attribute;
		return message;
	}

}
