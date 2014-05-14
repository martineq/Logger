package com.fiuba.tecnicas.logging;

public class SeparatorPattern extends Pattern{

	@Override
	public String getMessage() {
		
		return this.log.getSeparator(); 
	}

}
