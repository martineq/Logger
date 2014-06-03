package com.fiuba.tecnicas.logging.pattern;

import com.fiuba.tecnicas.logging.Log;

public abstract class Pattern {
	
	protected Log log;
	protected String attribute;
	protected String filter = ".*";
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


	public void addFilter(String filter) {
		this.filter  = filter.substring(1);
		
	}
	
	protected String applyFilter(String message) {
		return message.matches(this.filter) ? message :"" ;
	}
}
