package com.fiuba.tecnicas.logging.formatter;

/**
 * Clase que se encarga de decidir el tipo de formater 
 * que se ingresa.
 *
 */
public class FormatterManager {
	
	Formatter formatter;
	
	public FormatterManager(String format) {
		if(format.equals("JSON")){
			formatter = new JsonFormatter();
		}else{
			formatter = new UserFormatter(format);
		}
	}

	public Formatter getFormatter() {
		return this.formatter;
	}

}
