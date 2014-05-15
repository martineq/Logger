package com.fiuba.tecnicas.logging;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePattern extends Pattern {
	
	private String[] complementsMessages;
	private String attribute;
	
	public DatePattern(){
		
	}
	
	public void setAttributes(String attribute){
		this.attribute = attribute;
	}
	
	public String getMessage(){
		String message = this.parseAttribute();
		for(String aMessage: complementsMessages)
			message += aMessage;
		return message;
	}
	
	public void setLog(Log log){
		this.log = log;
	}
	
	private String parseAttribute() {
		Date date = this.log.getDate();
		Format formatter = new SimpleDateFormat(this.getDateFormat());
		obtainsComplementsMessages();
		String dateformated = formatter.format(date);
		return dateformated;
	}
	
	/**
	 * obtenemos en complementsMessages todos los strings que estan comprendidos luego
	 * de  la definicion del formato de simpleDateFormat y el proximo patron (proximo %)
	 *  o fin de linea
	 */
	private void obtainsComplementsMessages(){
		String attributeWithOutIdDatePattern = attribute.substring(1);
		complementsMessages = attributeWithOutIdDatePattern.split("\\{.*\\}");
		
	}
	
	private String getDateFormat() {
		String[] result = attribute.split("\\{|\\}");     
		return result[1];
	}
}
