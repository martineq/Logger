package com.fiuba.tecnicas.logging.pattern;


public class MethodPattern extends Pattern {
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		String message = Thread.currentThread().getStackTrace()[layerCalledLogSave].getMethodName(); 
		message += attribute;
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof MethodPattern;
	}

}
