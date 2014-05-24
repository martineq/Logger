package com.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;
import com.fiuba.tecnicas.logging.Pattern.Pattern;




/**
 * 
 * @author damian
 *
 */
public class MessageParser {

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
	
	
	/**
	 * se obtiene cada uno de los patrones del formato de mensaje.
	 */
	
	private void parseMessage(){
		
		String[] parts = this.message.split("%");
		for (String part : parts) 
			this.savePattern(part);
	}

	private boolean isPorcentajeSimbol(String part ){
		return part.equals("");
	}
	
	
	/**
	 *  
	 * @param part, cadena luego del % para obtener el primer caracter y asi crear la instancia
	 * del patron correspondiente.
	 */
	private void savePattern(String part) {
		if(!this.isPorcentajeSimbol(part)){
			Pattern pattern = this.getOption(part);
			pattern.setAttributes(part);
			pattern.setLog(log);
			formattedMessages.add(pattern);
		}
			
		
	}
	private Pattern getOption(String part){
		return messageFunctions.getFunctionName(String.valueOf(part.charAt(0)));
	}
	
	public String getMessage() {
		this.parseMessage();
		String message = "";
		for (Pattern pattern : formattedMessages)
			message += pattern.getMessage();
		
		return message;
	}

}
