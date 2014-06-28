package com.fiuba.tecnicas.logging.pattern;


public class ThreadPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = Thread.currentThread().getName();
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof ThreadPattern;
	}
	
	
}