package com.fiuba.tecnicas.logging;

import java.util.Date;

import com.fiuba.tecnicas.logging.formatter.Formatter;


public class Log {

		
	private Date date;
	private String level;
	protected LoggerSettings config;
	protected String message;
	
	
	public Log(String message, String level){
		this.message = message;
		date = new Date();
		this.level = level;
	}

	public Date getDate() {
		return this.date;
		
	}
	
	public String getSeparator(){
		return this.config.getSeparator();
	}
	
	public String save(){
		String messageToSave = getMessageToSave();
		LoggerFilters filters = this.config.getLoggerFilters();
		if(filters.matchesTheLoggerFilter(messageToSave)){
			return this.config.getSaver().save(messageToSave);
		}
		return "";
	}
	
	/**
	 * 
	 * @return messageToSave, es el mensaje que realmente se debe loggear teniendo en cuenta
	 * 		   la configuracion del log y el formato del mensaje.
	 */
	protected String getMessageToSave() {
		Formatter formatter = initFormatter();
		String messageToSave = formatter.getMessage();
		return messageToSave;
	}

	private Formatter initFormatter() {
		Formatter formatter = config.getFormatter();
		formatter.setLog(this);
		return formatter;
	}
	public void setConfig(LoggerSettings config) {
		this.config = config;
		
	}
	
	public String getMessage() {
		return this.message;
		
	}
	public String getLevel() {
		return this.level;
	}
	
	public String[] getFilePaths(){
		return this.config.getFilePaths();
	}

	public String getLoggerName() {
		return this.config.getLoggerName();
	}
	

}
