package com.fiuba.tecnicas.logging;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * @author damian
 *
 */
public class MessageParser {

	private Date date;
	private String message;
	private List<Pattern> formattedMessages =  new ArrayList<Pattern>();
	private MessageFunctionConstants messageFunctions = new MessageFunctionConstants();
	private Log log;
	
	/**
	 * 
	 * @param message
	 */
	public MessageParser(String message) {
		//this.date = date != null ? date : new Date();
		this.message = message;
		
	}
	
	public void setLog(Log log){
		this.log = log;
	}
	
	private void validateInputMessage(){
		//TODO:: deberia tirar una eception si no viene algo valido
	}
	
	private void parseMessage(){
		
		String[] parts = this.message.split("%");
		for (String part : parts) {
			this.savePattern(part);
			this.saveSeparator(part);
		}
	}

	private boolean isPorcentajeSimbol(String part ){
		return part.equals("");
	}
	
	private void saveSeparator(String part) {
		// TODO Auto-generated method stub
		
	}

	private void savePattern(String part) {
		if(!this.isPorcentajeSimbol(part)){
			try {
				Class aClass = Class.forName("com.fiuba.tecnicas.logging."+this.getOption(part));
				Pattern pattern = (Pattern) aClass.newInstance();
				pattern.setAttributes(part);
				pattern.setLog(log);
				formattedMessages.add(pattern);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
			
		
	}
	private String getOption(String part){
		return messageFunctions.getFunctionName(String.valueOf(part.charAt(0)));
	}
	
	public String getMessage() {
		this.parseMessage();
		String message = "";
		
		for (Pattern pattern : formattedMessages) {
			message += pattern.getMessage()+getSeparator();
		}
		return message;
	}

	private String getSeparator() {
		return this.log.getSeparator();
	}

}
