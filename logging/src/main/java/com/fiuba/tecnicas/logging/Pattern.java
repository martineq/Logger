package com.fiuba.tecnicas.logging;

public abstract class Pattern {
	
	protected Log log;
	protected String attribute;
	public abstract String getMessage();

	public  void setAttributes(String part) {
	}
	
	public void setLog(Log log){
		this.log = log;
	}
}
