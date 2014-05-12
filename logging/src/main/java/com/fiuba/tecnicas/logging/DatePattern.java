package com.fiuba.tecnicas.logging;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePattern extends Pattern {
	
	private String msj = "casa";
	private String attribute;
	
	public DatePattern(){
		
	}
	
	public void setAttributes(String attribute){
		this.attribute = attribute;
	}
	
	public String getMessage(){
		return this.parseAttribute();
	}
	
	public void setLog(Log log){
		this.log = log;
	}
	
	private String parseAttribute() {
		Date date = this.log.getDate();
		Format formatter = new SimpleDateFormat(this.getDateFormat());
		String dateformated = formatter.format(date);
		return dateformated;
	}

	private String getDateFormat() {
		String[] result = attribute.split("\\{|\\}");
		return result[1];
	}
}
