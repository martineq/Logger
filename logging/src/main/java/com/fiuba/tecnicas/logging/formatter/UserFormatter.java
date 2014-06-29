package com.fiuba.tecnicas.logging.formatter;

import java.util.ArrayList;
import java.util.List;

import com.fiuba.tecnicas.logging.Log;
import com.fiuba.tecnicas.logging.MessageFunctionConstants;
import com.fiuba.tecnicas.logging.pattern.Pattern;
import com.fiuba.tecnicas.logging.pattern.PorcentajePattern;




/**
 * 
 * @author damian
 * Clase que se encarga de manejar el parseo de los formatos 
 * ingresados por el usuario.
 *
 */
public class UserFormatter implements Formatter{

	private String format;
	private List<Pattern> formattedMessages =  new ArrayList<Pattern>();
	private MessageFunctionConstants messageFunctions = new MessageFunctionConstants();
	private Log log;
	private String customFilters;
	
	/**
	 * Constructor de la clase
	 * @param message
	 */
	public UserFormatter(String message) {
		this.format = message;
		
	}
	
	public void setLog(Log log){
		this.log = log;
	}
	
	
	/**
	 * se obtiene cada uno de los patrones del formato de mensaje.
	 */
	
	private void parseMessage(){
		
		String[] parts = this.format.split("%");
		boolean isEmptyLastMessage = false;
		int i = 0; // la primera cadena siempre es vacia porque siempre arranca con un patron
		for (String part : parts){ 
			if (i != 0){
				if (isPercentSymbol(part) && !isEmptyLastMessage)
					isEmptyLastMessage = true;
				else{
					this.savePattern(part,isEmptyLastMessage);
					isEmptyLastMessage = false;
				}
			}
			i++;
		}
	}

	private boolean isPercentSymbol(String part ){
		return part.equals("");
	}
	
	
	/**
	 *  
	 * @param part, cadena luego del % para obtener el primer caracter y asi crear la instancia
	 * del patron correspondiente.
	 */
	private void savePattern(String part, boolean youMustCreatePercentagePattern) {
		if(!youMustCreatePercentagePattern){
			Pattern pattern = this.getOption(part);
			if(pattern == null){
				return; //No hay nada asociado a ese pattern
			}
			pattern.setAttributes(part);
			pattern.setLog(log);
			formattedMessages.add(pattern);
		}else{
			Pattern pattern = new PorcentajePattern();
			pattern.setAttributes(part);
			pattern.setLog(log);
			formattedMessages.add(pattern);
			//formattedMessages.add(new PorcentajePattern());
		}
			
		
	}
	/**
	 * 
	 * @param part
	 * Busca una entidad del tipo Pattern que represente
	 *  el formato ingresado por el usuario
	 */
	private Pattern getOption(String part){
		return messageFunctions.getFunctionName(String.valueOf(part.charAt(0)));
	}
	
	public String getMessage() {
		this.parseMessage();
		this.parseFilters();
		String message = "";
		for (Pattern pattern : formattedMessages){
			String messageToAppend = pattern.getMessage();
			if(messageToAppend.equals("")){
				return "";
			}
			message += messageToAppend;
		}
			
		
		return message;
	}

	@Override
	public void setCustomFilters(String customFilters) {
		this.customFilters = customFilters;
		
	}
	
	private void parseFilters() {
		String[] parts = this.customFilters.split("%");
		for (String part : parts){
			if(!this.isPercentSymbol(part)){
				Pattern pattern = this.getOption(part);
				for (Pattern patternInList : formattedMessages){
					if(patternInList.equals(pattern)){
						patternInList.addFilter(part);
					}
				}
			}	
		}
			
		
	}

}
