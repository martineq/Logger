package com.fiuba.tecnicas.logging.pattern;


public class LineNumberPattern extends Pattern{
	private static int  layerCalledLogSave = 5;
	
	@Override
	public String getMessage() {
		int level = Thread.currentThread().getStackTrace().length -1 ;
		String message = String.valueOf(Thread.currentThread().getStackTrace()[level].getLineNumber()); 
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof LineNumberPattern;
	}


}
