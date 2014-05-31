package com.fiuba.tecnicas.logging.pattern;

import java.util.ArrayList;


public class SeparatorPattern extends Pattern{
	private ArrayList<String> attributes;
	
	
	public SeparatorPattern(){
		attributes = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param part , , string que continua despues del %, hasta el proximo patron
	 *  (proximo %) o fin de linea
	 */
	@Override
	public  void setAttributes(String part) {
		this.attribute = part.substring(1);
		this.attributes.add(attribute);
	}
	
	@Override
	public String getMessage() {
		String message = this.log.getSeparator();
		message += this.attributes.get(0);
		this.attributes.remove(0);
		return message;
	}

}
