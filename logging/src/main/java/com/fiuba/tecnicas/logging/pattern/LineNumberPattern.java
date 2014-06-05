package com.fiuba.tecnicas.logging.pattern;


public class LineNumberPattern extends Pattern{
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = String.valueOf(Thread.currentThread().getStackTrace()[layerCalledLogSave].getLineNumber()); 
		message += attribute;
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof LineNumberPattern;
	}


}
