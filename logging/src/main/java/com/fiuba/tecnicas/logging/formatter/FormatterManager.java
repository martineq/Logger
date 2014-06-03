package com.fiuba.tecnicas.logging.formatter;

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
