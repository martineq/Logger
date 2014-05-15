package com.fiuba.tecnicas.logging;

public class LineNumberPattern extends Pattern{
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = String.valueOf(Thread.currentThread().getStackTrace()[layerCalledLogSave].getLineNumber()); 
		message += attribute;
		return message;
	}


}
