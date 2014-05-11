package com.fiuba.tecnicas.logging;

public abstract class Pattern {
	
	protected Log log;
	
	public abstract String getMessage();

	public  void setAttributes(String part) {
	}
	
	public void setLog(Log log){
		this.log = log;
	}
}
