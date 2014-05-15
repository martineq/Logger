package com.fiuba.tecnicas.logging;

public abstract class Pattern {
	
	protected Log log;
	protected String attribute;
	public abstract String getMessage();
	
	
	/**
	 * 
	 * @param part , , string que continua despues del %, hasta el proximo patron
	 *  (proximo %) o fin de linea
	 */
	public  void setAttributes(String part) {
		this.attribute = part.substring(1);
	}
	
	public void setLog(Log log){
		this.log = log;
	}
}
